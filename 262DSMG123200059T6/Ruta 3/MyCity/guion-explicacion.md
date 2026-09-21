# Guión de explicación — "Lima: Mi Ciudad"

App de recomendaciones en Jetpack Compose con **Navigation** de Jetpack, **ViewModel + flujo unidireccional de datos (UDF)**, separación clara entre **capa de datos** y **capa de IU**, y **diseño adaptable** según los lineamientos de **Material Design**.

> Cómo usar este guión: cada bloque indica qué archivo abrir, qué mostrar en pantalla y qué decir. Son puntos de apoyo para explicar con tus propias palabras, no un texto para leer de memoria.

---

## 1. Antes de empezar (preparación)

- Tener el proyecto abierto en Android Studio.
- Correr la app una vez para ver las 3 pantallas: inicio → categoría → detalle.
- En el panel **Project**, activar la vista **Android** para que se vean las carpetas `java` y `res`.

**Estructura general para mostrar:**

```
app/src/main/java/com/example/mycity/
├── MainActivity.kt
├── data/                  ← CAPA DE DATOS
│   ├── Recommendation.kt
│   ├── Category.kt
│   └── RecommendationRepository.kt
└── ui/                    ← CAPA DE IU
    ├── MyCityUiState.kt
    ├── MyCityViewModel.kt
    ├── MyCityApp.kt
    ├── home/HomeScreen.kt
    ├── category/CategoryScreen.kt
    ├── detail/DetailScreen.kt
    └── theme/ (Color.kt, Theme.kt, Type.kt)
```

**Qué decir:** "La app respeta una separación de capas: la **capa de datos** define qué es una recomendación y de dónde salen los datos, y la **capa de IU** solo se encarga de mostrarlos. El puente entre ambas es el ViewModel, que expone el estado al que la UI reacciona."

---

## 2. Capa de datos — `data/Recommendation.kt`

**Qué abrir:** `app/src/main/java/com/example/mycity/data/Recommendation.kt`

```kotlin
data class Recommendation(
    val id: Int,            // identificador único
    val nameRes: Int,       // recurso de cadena: nombre del lugar
    val descriptionRes: Int,// recurso de cadena: descripción
    val imageRes: Int,      // recurso de imagen
)
```

**Qué decir:**
- Es una **data class**: modela un "lugar recomendado" como datos puros (sin comportamiento).
- Los textos e imágenes se referencian con **recursos de Android** (`R.string.*`, `R.drawable.*`), no con cadenas sueltas. Ventaja: mejor localización y un solo lugar donde están los textos (`values/strings.xml`).

---

## 3. Capa de datos — `data/Category.kt` y `data/RecommendationRepository.kt`

**Qué abrir:** `data/Category.kt` y `data/RecommendationRepository.kt`

```kotlin
data class Category(
    val id: Int,
    val nameRes: Int,
    val iconRes: Int,
    val imageRes: Int,
    val recommendations: List<Recommendation>,  // la categoría trae sus lugares
)
```

**Qué decir:**
- Una **categoría** agrupa sus recomendaciones (Cafeterías, Restaurantes, Museos, Parques, Centros comerciales, Lugares para niños).
- `RecommendationRepository` es un **`object` singleton**: es la **única fuente de datos** de la app.
- **Demostración de dominio:** "La capa de datos no sabe nada de Compose ni de la pantalla. La UI consume estas listas y nunca las modifica ni las crea. Esto es lo que se busca al separar las capas."

---

## 4. UDF — `ui/MyCityUiState.kt` y `ui/MyCityViewModel.kt`

**Qué abrir:** `ui/MyCityViewModel.kt` (y mostrar `MyCityUiState.kt`)

```kotlin
data class MyCityUiState(
    val currentCategory: Category? = null,
    val currentRecommendation: Recommendation? = null,
)
```

```kotlin
class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        _uiState.update { it.copy(currentCategory = category) }
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update { it.copy(currentRecommendation = recommendation) }
    }

    fun resetRecommendation() { _uiState.update { it.copy(currentRecommendation = null) } }
    fun resetState() { _uiState.value = MyCityUiState() }
}
```

**Qué decir — el patrón de flujo unidireccional de datos (UDF):**
1. **Single source of truth:** `uiState` es un `StateFlow`. Es la única versión del estado de la app.
2. **Las funciones son "eventos"**: la UI no modifica estado; le *pide* al ViewModel (`updateCurrentCategory`, etc.).
3. **Estado inmutable**: cada cambio se hace con `copy(...)`, nunca mutando el objeto anterior.
4. **Observable**: la UI observa el `StateFlow` (`collectAsState()`) y se redibuja sola cuando algo cambia.
- Se usa `MutableStateFlow` privado y se expone solo la versión de solo lectura con `.asStateFlow()`.
- Por qué `StateFlow`: es observable, retiene el último valor y vive en el ViewModel, que sobrevive a los cambios de configuración (rotación).

---

## 5. Navegación — `ui/MyCityApp.kt`

**Qué abrir:** `ui/MyCityApp.kt`

**Qué mostrar / decir:**
- Las **rutas** se definen como constantes: `home`, `category`, `detail`.
- `rememberNavController()` + `NavHost(...)` construyen el **gráfico de navegación** con tres destinos `composable(...)`.
- **Lo clave — la navegación guiada por el estado:**

```kotlin
LaunchedEffect(uiState.currentCategory, uiState.currentRecommendation) {
    val destination = navController.currentDestination?.route
    when {
        destination == HOME_ROUTE && uiState.currentCategory != null ->
            navController.navigate(CATEGORY_ROUTE)
        destination == CATEGORY_ROUTE && uiState.currentRecommendation != null ->
            navController.navigate(DETAIL_ROUTE)
    }
}
```

- "Cuando el usuario toca una categoría, el ViewModel cambia el estado; **este efecto reacciona** y navega a la pantalla correspondiente. La UI no decide navegar por su cuenta."
- **Limpieza del back stack** al volver:

```kotlin
LaunchedEffect(navController) {
    navController.currentBackStackEntryFlow.collect { backStackEntry ->
        when (backStackEntry?.destination?.route) {
            CATEGORY_ROUTE -> viewModel.resetRecommendation()
            HOME_ROUTE     -> viewModel.resetState()
        }
    }
}
```

- "Al regresar a una pantalla, se limpie el estado que ya no corresponde (ej.: al volver a la categoría se borra la recomendación seleccionada). Esto mantiene el estado consistente con el lugar donde está el usuario."

**Demostración en vivo:** tocar "Restaurantes" en el emulador → se abre la categoría. Volver con la flecha → estados reseteados. Esto prueba el ciclo **evento → estado → UI + navegación**.

---

## 6. Pantalla de inicio — `ui/home/HomeScreen.kt`

**Qué abrir:** `ui/home/HomeScreen.kt`

**Qué decir:**
- `Scaffold` con `CenterAlignedTopAppBar` (título "Lima: Mi Ciudad").
- La grilla `LazyVerticalGrid` con `GridCells.Adaptive(minSize = 160.dp)`: **las columnas se ajustan solas al ancho disponible** (2 columnas en celular, más en tablet).
- Cada categoría es una `Card` clicable con imagen + nombre.
- **Adaptable:** si la pantalla no es compacta (≥600dp) se muestra un **`NavigationRail`** lateral con los atajos a las categorías.

![flujo visual: inicio → categoría → detalle]

---

## 7. Pantalla de categoría — `ui/category/CategoryScreen.kt`

**Qué abrir:** `ui/category/CategoryScreen.kt`

**Qué decir:**
- `TopAppBar` con el nombre de la categoría y el botón **volver** (IconButton + `ic_back`).
- **Diseño adaptable según el ancho:**
  - Pantalla compacta → `LazyColumn` (lista de filas con imagen a la izquierda).
  - Pantalla mediana/expandida → `LazyVerticalGrid` `GridCells.Adaptive(minSize = 220.dp)`.
- Cada elemento es una `ElevatedCard` con imagen, título y descripción (recortada con `maxLines = 2`).

---

## 8. Pantalla de detalle — `ui/detail/DetailScreen.kt`

**Qué abrir:** `ui/detail/DetailScreen.kt`

**Qué decir:**
- Top bar con el nombre del lugar y botón volver.
- Imagen grande con `aspectRatio(16:9)` y textos (nombre con `headlineMedium`, descripción con `bodyLarge`).
- **Adaptable:** el contenido se **centra y limita a 840dp de ancho** (`widthIn(max = 840.dp)`) en pantallas grandes, manteniendo la lectura cómoda en tablets horizontales.

---

## 9. Diseño adaptable — `CityWindowSize`

**Qué abrir:** `ui/MyCityApp.kt` (la función `rememberCityWindowSize`)

```kotlin
when {
    widthDp < 600 -> CityWindowSize.Compact
    widthDp < 840 -> CityWindowSize.Medium
    else         -> CityWindowSize.Expanded
}
```

**Qué decir — lineamientos de Material Design:**
- Material define **puntos de quiebre (breakpoints)**: compact (<600dp), medium (600–839dp) y expanded (≥840dp).
- Según eso la app cambia:
  - Navegación: rail lateral en medium/expanded, sin barra en compact (tarjetas de categoría como acceso principal).
  - Contenido: lista ↔ grilla.
  - Detalle: contenido centrado con ancho máximo.
- "No diseñamos por dispositivo, sino por **tamaño de ventana**; así el layout se adapta a celulares, tablets y ventanas redimensionables."

---

## 10. Material Design y tema — `ui/theme/`

**Qué abrir:** `ui/theme/Color.kt` y `ui/theme/Theme.kt`

**Qué decir:**
- Paleta personalizada inspirada en Lima: **terracota** (barro prehispánico), **teal** (la costa) y **dorado** (atardeceres).
- `Color.kt` define la paleta; `Theme.kt` la organiza en `lightColorScheme()` y `darkColorScheme()`.
- `MyCityTheme` detecta el tema del sistema con `isSystemInDarkTheme()` y aplica el esquema correspondiente.
- Componentes de Material 3 usados en toda la app: `Scaffold`, `TopAppBar`, `NavigationRail`, `Card`, `ElevatedCard`, `Text`, `Icon`, `IconButton`.

**Demostración en vivo:** cambiar el teléfono de modo claro a oscuro → la app cambia sola.

---

## 11. Actividad principal — `MainActivity.kt`

**Qué abrir:** `MainActivity.kt`

**Qué decir:**
- `enableEdgeToEdge()` → contenido dibujado detrás de las barras del sistema.
- `setContent { MyCityTheme { MyCityApp() } }` → el tema envuelve la app completa.

---

## 12. Cierre — qué demostrar en la práctica

1. Tocar una categoría → se abre la lista (navegación reactiva al estado).
2. Tocar un lugar → detalle con imagen y descripción.
3. Volver → el estado se resetea y la app queda consistente.
4. Girar el emulador o usar un dispositivo ancho → el layout cambia (grilla, rail, detalle centrado).
5. Cambiar tema claro/oscuro → colores cambian.

---

## Posibles preguntas del evaluador (y pistas de respuesta)

**¿Cómo separas la capa de datos de la capa de IU?**
La capa de datos (`data/`) solo modela información con `data class` y el repositorio que la entrega. La UI (`ui/`) solo renderiza. Nadie de la UI crea ni modifica datos.

**¿Qué es el flujo unidireccional de datos (UDF) y cómo se aplica?**
Un solo sentido: el usuario produce un **evento** → el **ViewModel** actualiza el **estado** inmutable → la **UI observa** el `StateFlow` y se redibuja → y reacciona (navegando, por ejemplo). La UI nunca escribe el estado directamente.

**¿Por qué StateFlow y no una variable normal?**
Porque es observable: la UI se actualiza automáticamente cuando cambia el estado, retiene el último valor y al vivir en el ViewModel sobrevive a la rotación de pantalla.

**¿Cómo hace la navegación con Jetpack Navigation?**
Con `NavHost` + `rememberNavController` y destinos `composable("ruta")`. La particularidad: la navegación **no se dispara desde el click**, sino que reacciona al estado del ViewModel mediante `LaunchedEffect`, y el evento de back stack limpia el estado.

**¿Cómo se logra el layout adaptable?**
Clasificando el ancho de la ventana en compact/medium/expanded, y eligiendo componentes según eso: pantallas listas/grillas, `NavigationRail` en anchos grandes y contenido con ancho máximo. Se usan `GridCells.Adaptive` que ya se adaptan solas.

**¿Por qué los textos van en `strings.xml` con identificadores?**
Para facilitar la traducción y centralizar el contenido. En la capa de datos se guarda la referencia al recurso, no la cadena.