package com.example.app30dias

import androidx.annotation.DrawableRes
import com.example.app30dias.R

data class Receta(
    val dia: Int,
    val titulo: String,
    val descripcion: String,
    val ingredientes: String,
    val tiempoMinutos: Int,
    val dificultad: String,
    @param:DrawableRes val imagenRes: Int
)

val recetas = listOf(
    Receta(
        dia = 1,
        titulo = "Ceviche",
        descripcion = "El plato bandera del Perú: pescado fresco macerado en jugo de limón con ají limo, cebolla roja y culantro. Se sirve con camote, choclo y cancha.",
        ingredientes = "Pescado blanco (corvina), limón, ají limo, cebolla roja, culantro, camote, choclo, cancha, sal",
        tiempoMinutos = 30,
        dificultad = "Media",
        imagenRes = R.drawable.receta_1
    ),
    Receta(
        dia = 2,
        titulo = "Lomo saltado",
        descripcion = "Res salteada a fuego vivo con cebolla, tomate y ají amarillo, lista en minutos y servida sobre papas fritas con arroz. El sabor criollo hecho plato.",
        ingredientes = "Lomo fino, cebolla, tomate, ají amarillo, sillao, vinagre, culantro, papas fritas, arroz",
        tiempoMinutos = 30,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_2
    ),
    Receta(
        dia = 3,
        titulo = "Ají de gallina",
        descripcion = "Pollo deshilachado en una crema de ají amarillo, pan, leche y nueces que espesa y aromatiza. Se sirve sobre papas sancochadas con huevo y aceitunas.",
        ingredientes = "Gallina o pollo, ají amarillo, pan de molde, leche evaporada, nueces, queso parmesano, cebolla, papa amarilla, huevo, aceituna",
        tiempoMinutos = 60,
        dificultad = "Media",
        imagenRes = R.drawable.receta_3
    ),
    Receta(
        dia = 4,
        titulo = "Pollo a la brasa",
        descripcion = "El rey de los domingos peruanos: pollo marinado en ají panca, sillao y especias, asado a la brasa con la piel dorada y crujiente.",
        ingredientes = "Pollo entero, ají panca, sillao, ajo, comino, pimienta, orégano, papas fritas, ensalada, crema de ají",
        tiempoMinutos = 120,
        dificultad = "Media",
        imagenRes = R.drawable.receta_4
    ),
    Receta(
        dia = 5,
        titulo = "Anticuchos",
        descripcion = "Corazón de res macerado en vinagre, ají panca y ajo, ensartado en palitos y asado a la parrilla. Se sirven con papa sancochada y ají de rocoto.",
        ingredientes = "Corazón de res, ají panca, vinagre, ajo, comino, sal, pimienta, papa sancochada, ají de rocoto",
        tiempoMinutos = 45,
        dificultad = "Media",
        imagenRes = R.drawable.receta_5
    ),
    Receta(
        dia = 6,
        titulo = "Causa limeña",
        descripcion = "Capas de papa amarilla prensada con ají amarillo y limón, rellenas de pollo o atún con mayonesa y palta. Un clásico servido frío.",
        ingredientes = "Papa amarilla, ají amarillo, limón, aceite, pollo o atún, mayonesa, palta, huevo, aceituna",
        tiempoMinutos = 45,
        dificultad = "Media",
        imagenRes = R.drawable.receta_6
    ),
    Receta(
        dia = 7,
        titulo = "Papa a la huancaína",
        descripcion = "Papas sancochadas bañadas en la cremosa salsa huancaína de queso fresco, ají amarillo y leche. Una de las entradas más queridas del Perú.",
        ingredientes = "Papas amarillas, queso fresco, ají amarillo, leche evaporada, galleta de soda, aceite, huevo, aceituna, lechuga",
        tiempoMinutos = 30,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_7
    ),
    Receta(
        dia = 8,
        titulo = "Arroz con pollo",
        descripcion = "El arroz verde peruano, teñido y perfumado con culantro, cocinado con pollo dorado, zanahoria y alverjas. Infaltable a la hora del almuerzo.",
        ingredientes = "Pollo, arroz, culantro, ají amarillo, cebolla, ajo, cerveza, alverjas, zanahoria, pimiento, comino",
        tiempoMinutos = 60,
        dificultad = "Media",
        imagenRes = R.drawable.receta_8
    ),
    Receta(
        dia = 9,
        titulo = "Seco de res",
        descripcion = "Guiso de carne de res en salsa verde de culantro, ají amarillo y chicha de jora. Se sirve encima de frejoles canarios con arroz o yuca.",
        ingredientes = "Carne de res, culantro, ají amarillo, cebolla, ajo, chicha de jora, alverjas, zanahoria, frejoles, arroz",
        tiempoMinutos = 90,
        dificultad = "Media",
        imagenRes = R.drawable.receta_9
    ),
    Receta(
        dia = 10,
        titulo = "Carapulcra",
        descripcion = "Guiso espeso y profundo de papa seca con cerdo, ají panca y maní tostado. De herencia precolombina, es puro sabor andino.",
        ingredientes = "Papa seca, carne de cerdo, ají panca, maní tostado, cebolla, ajo, comino, mole, caldo",
        tiempoMinutos = 120,
        dificultad = "Media",
        imagenRes = R.drawable.receta_10
    ),
    Receta(
        dia = 11,
        titulo = "Rocoto relleno",
        descripcion = "Rocotos picantes rellenos de carne sazonada, queso y papas, horneados en una crema de leche y huevo. Mucho sabor y bastante carácter.",
        ingredientes = "Rocoto, carne molida, cebolla, ajo, ají amarillo, papas, queso fresco, huevos, leche, aceituna",
        tiempoMinutos = 70,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_11
    ),
    Receta(
        dia = 12,
        titulo = "Tallarines verdes",
        descripcion = "Tallarines con una salsa criolla de espinacas, albahaca y queso parmesano, coronados con un lomo fino salteado. El pesto a la peruana.",
        ingredientes = "Tallarines, espinacas, albahaca, queso parmesano, leche evaporada, ajo, aceite, lomo fino, cebolla, tomate",
        tiempoMinutos = 45,
        dificultad = "Media",
        imagenRes = R.drawable.receta_12
    ),
    Receta(
        dia = 13,
        titulo = "Tallarines rojos",
        descripcion = "Tallarines en una salsa roja de tomate y ají amarillo con carne salteada. Simple, contundente y muy popular en las mesas peruanas.",
        ingredientes = "Tallarines, tomate, ají amarillo, cebolla, ajo, lomo fino, sillao, queso parmesano, orégano",
        tiempoMinutos = 40,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_13
    ),
    Receta(
        dia = 14,
        titulo = "Arroz con pato",
        descripcion = "El arroz verde del norte, cocinado con culantro, ají amarillo y chicha de jora, con presas de pato tiernas en su propio jugo. Se corona con salsa criolla.",
        ingredientes = "Pato, arroz, culantro, ají amarillo, zapallo loche, chicha de jora o cerveza negra, alverjas, pimiento, salsa criolla",
        tiempoMinutos = 120,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_14
    ),
    Receta(
        dia = 15,
        titulo = "Cabrito a la norteña",
        descripcion = "Guiso de cabrito macerado en chicha de jora, ají amarillo y culantro, cocido a fuego lento hasta deshacerse. Un clásico de la costa norte.",
        ingredientes = "Cabrito, chicha de jora, ají amarillo, ají panca, cebolla, ajo, culantro, zapallo loche, frejoles, arroz",
        tiempoMinutos = 120,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_15
    ),
    Receta(
        dia = 16,
        titulo = "Pachamanca",
        descripcion = "Festín andino cocido bajo tierra sobre piedras calientes: carnes aderezadas, papas, choclo, habas y humitas envueltos en hojas. Cocción lenta y sabor ahumado.",
        ingredientes = "Res, cerdo, pollo, cuy, ají panca, chincho, huacatay, ajo, chicha de jora, papas, camote, choclo, habas, humitas",
        tiempoMinutos = 180,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_16
    ),
    Receta(
        dia = 17,
        titulo = "Juane",
        descripcion = "Bola de arroz con gallina, huevo y aceituna, envuelta en hoja de bijao y hervida. El plato imprescindible de la Fiesta de San Juan en la Amazonía.",
        ingredientes = "Arroz, gallina, huevo, aceituna, hoja de bijao, palillo, ajo, orégano, comino",
        tiempoMinutos = 90,
        dificultad = "Media",
        imagenRes = R.drawable.receta_17
    ),
    Receta(
        dia = 18,
        titulo = "Tacacho con cecina",
        descripcion = "Bolas de plátano bellaco verde aplastado con manteca y chicharrón, acompañadas de cecina ahumada de cerdo y un toque de ají de cocona. Sabor de la selva.",
        ingredientes = "Plátano bellaco verde, manteca de cerdo, chicharrón, cecina de cerdo, cocona, ají charapita",
        tiempoMinutos = 40,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_18
    ),
    Receta(
        dia = 19,
        titulo = "Chupe de camarones",
        descripcion = "El chupe arequipeño: caldo espeso y cremoso de camarones de río con papas, choclo, arroz, queso, leche evaporada y huacatay. Gloria del sur peruano.",
        ingredientes = "Camarones, papas, choclo, arroz, habas, cebolla, ají panca, huacatay, queso fresco, leche evaporada, huevo",
        tiempoMinutos = 60,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_19
    ),
    Receta(
        dia = 20,
        titulo = "Parihuela",
        descripcion = "Sopa de mariscos del Callao: un caldo cargado de corvina, camarones, choros, conchas y cangrejo, perfumado con kion, rocoto y culantro. El 'levanta muertos' de la costa.",
        ingredientes = "Pescado blanco, camarones, choros, conchas de abanico, cangrejo, pulpo, cebolla, tomate, ají amarillo, ají panca, kion, rocoto, culantro",
        tiempoMinutos = 70,
        dificultad = "Media",
        imagenRes = R.drawable.receta_20
    ),
    Receta(
        dia = 21,
        titulo = "Aguadito de pollo",
        descripcion = "Sopa espesa y reconfortante de pollo, arroz y verduras, de color verde intenso por el culantro. El clásico plato de resurrección de la cocina criolla.",
        ingredientes = "Pollo, arroz, culantro, ají amarillo, papa, zanahoria, alverjas, choclo, cebolla, ajo, kion",
        tiempoMinutos = 45,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_21
    ),
    Receta(
        dia = 22,
        titulo = "Sopa criolla",
        descripcion = "Sopa limeña de carne de res, fideos cabello de ángel y leche, con ají panca y tomate. Se sirve muy caliente, coronada con un huevo frito.",
        ingredientes = "Carne de res, fideos cabello de ángel, cebolla, ajo, ají panca, tomate, pasta de tomate, orégano, leche evaporada, huevo",
        tiempoMinutos = 40,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_22
    ),
    Receta(
        dia = 23,
        titulo = "Tacu tacu",
        descripcion = "Tortilla dorada de arroz y frejoles cremosos del día anterior, con aderezo de ají amarillo. Se corona con huevo frito y plátano al costado.",
        ingredientes = "Arroz cocido, frejoles canarios, cebolla, ajo, ají amarillo, comino, huevo frito, plátano frito",
        tiempoMinutos = 35,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_23
    ),
    Receta(
        dia = 24,
        titulo = "Estofado de pollo",
        descripcion = "Pollo guisado lentamente en salsa de tomate, cebolla y ají, con papas, zanahoria y alverjas. Un guiso casero, rico y de cuchara.",
        ingredientes = "Pollo, cebolla, ajo, tomate, ají amarillo, ají panca, papa, zanahoria, alverjas, vino o cerveza, laurel",
        tiempoMinutos = 60,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_24
    ),
    Receta(
        dia = 25,
        titulo = "Olluquito con charqui",
        descripcion = "Guiso andino de olluco en tiras con charqui desmenuzado, ají amarillo y especias: el matrimonio milenario de la papa del olluco y la carne seca.",
        ingredientes = "Ollucos, charqui de res o alpaca, cebolla, ajo, ají amarillo, ají panca, comino, perejil",
        tiempoMinutos = 50,
        dificultad = "Media",
        imagenRes = R.drawable.receta_25
    ),
    Receta(
        dia = 26,
        titulo = "Cau cau",
        descripcion = "Guiso amarillo de mondongo con papas, ají amarillo, palillo y hierbabuena fresca. Se sirve con arroz y se corona con unas gotas de limón.",
        ingredientes = "Mondongo, papas, cebolla, ajo, ají amarillo, palillo (cúrcuma), hierbabuena, alverjas, zanahoria, caldo",
        tiempoMinutos = 120,
        dificultad = "Alta",
        imagenRes = R.drawable.receta_26
    ),
    Receta(
        dia = 27,
        titulo = "Mondonguito a la italiana",
        descripcion = "Panza de res en tiras salteada con tomate, zanahoria, alverjas y hongos, con un toque de queso parmesano. Se sirve con papas fritas y arroz.",
        ingredientes = "Mondongo, tomate, cebolla, ajo, zanahoria, alverjas, hongos, laurel, queso parmesano, papas fritas, arroz",
        tiempoMinutos = 90,
        dificultad = "Media",
        imagenRes = R.drawable.receta_27
    ),
    Receta(
        dia = 28,
        titulo = "Escabeche de pollo",
        descripcion = "Pollo dorado bañado en una salsa agridulce de cebollas en pluma, ají panca y vinagre. Se sirve templado con camote, huevo y aceituna negra.",
        ingredientes = "Pollo, cebolla roja, ají panca, ají amarillo, vinagre, orégano, laurel, comino, camote, huevo, aceituna negra, lechuga",
        tiempoMinutos = 50,
        dificultad = "Media",
        imagenRes = R.drawable.receta_28
    ),
    Receta(
        dia = 29,
        titulo = "Frejoles con seco",
        descripcion = "Frejoles canarios cremosos aderezados con tocineta y especias, que sirven de base al seco de res con todo su jugo. Se acompaña con arroz blanco.",
        ingredientes = "Frejol canario, costilla o tocineta de chancho, cebolla, ajo, orégano, seco de res, arroz blanco",
        tiempoMinutos = 90,
        dificultad = "Media",
        imagenRes = R.drawable.receta_29
    ),
    Receta(
        dia = 30,
        titulo = "Arroz chaufa",
        descripcion = "El clásico del chifa peruano: arroz frito a fuego vivo con pollo o chancho, huevo, cebolla china, verduras y sillao, con aroma de kion.",
        ingredientes = "Arroz, pollo o chancho, huevos, cebolla china, zanahoria, alverjas, kion, sillao, aceite de ajonjolí",
        tiempoMinutos = 30,
        dificultad = "Fácil",
        imagenRes = R.drawable.receta_30
    )
)