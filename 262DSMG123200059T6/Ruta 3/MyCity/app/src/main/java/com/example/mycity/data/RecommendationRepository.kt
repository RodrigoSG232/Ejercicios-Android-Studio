package com.example.mycity.data

import com.example.mycity.R

object RecommendationRepository {

    private val cafeterias = Category(
        id = 1,
        nameRes = R.string.category_cafeterias,
        iconRes = R.drawable.ic_cafe,
        imageRes = R.drawable.img_cafe,
        recommendations = listOf(
            Recommendation(
                id = 1,
                nameRes = R.string.cafeterias_cafe_flores,
                descriptionRes = R.string.cafeterias_cafe_flores_desc,
                imageRes = R.drawable.img_cafe_flores,
            ),
            Recommendation(
                id = 2,
                nameRes = R.string.cafeterias_la_moneda,
                descriptionRes = R.string.cafeterias_la_moneda_desc,
                imageRes = R.drawable.img_la_moneda,
            ),
            Recommendation(
                id = 3,
                nameRes = R.string.cafeterias_bisetti,
                descriptionRes = R.string.cafeterias_bisetti_desc,
                imageRes = R.drawable.img_bisetti,
            ),
            Recommendation(
                id = 4,
                nameRes = R.string.cafeterias_puku_puku,
                descriptionRes = R.string.cafeterias_puku_puku_desc,
                imageRes = R.drawable.img_puku_puku,
            ),
        ),
    )

    private val restaurantes = Category(
        id = 2,
        nameRes = R.string.category_restaurantes,
        iconRes = R.drawable.ic_restaurant,
        imageRes = R.drawable.img_restaurant,
        recommendations = listOf(
            Recommendation(
                id = 5,
                nameRes = R.string.restaurantes_central,
                descriptionRes = R.string.restaurantes_central_desc,
                imageRes = R.drawable.img_central,
            ),
            Recommendation(
                id = 6,
                nameRes = R.string.restaurantes_maido,
                descriptionRes = R.string.restaurantes_maido_desc,
                imageRes = R.drawable.img_maido,
            ),
            Recommendation(
                id = 7,
                nameRes = R.string.restaurantes_punto_azul,
                descriptionRes = R.string.restaurantes_punto_azul_desc,
                imageRes = R.drawable.img_punto_azul,
            ),
            Recommendation(
                id = 8,
                nameRes = R.string.restaurantes_rosa_nautica,
                descriptionRes = R.string.restaurantes_rosa_nautica_desc,
                imageRes = R.drawable.img_rosa_nautica,
            ),
        ),
    )

    private val museos = Category(
        id = 3,
        nameRes = R.string.category_museos,
        iconRes = R.drawable.ic_museum,
        imageRes = R.drawable.img_museum,
        recommendations = listOf(
            Recommendation(
                id = 9,
                nameRes = R.string.museos_larco,
                descriptionRes = R.string.museos_larco_desc,
                imageRes = R.drawable.img_museo_larco,
            ),
            Recommendation(
                id = 10,
                nameRes = R.string.museos_mali,
                descriptionRes = R.string.museos_mali_desc,
                imageRes = R.drawable.img_mali,
            ),
            Recommendation(
                id = 11,
                nameRes = R.string.museos_nacion,
                descriptionRes = R.string.museos_nacion_desc,
                imageRes = R.drawable.img_museo_nacion,
            ),
            Recommendation(
                id = 12,
                nameRes = R.string.museos_osma,
                descriptionRes = R.string.museos_osma_desc,
                imageRes = R.drawable.img_museo_osma,
            ),
        ),
    )

    private val parques = Category(
        id = 4,
        nameRes = R.string.category_parques,
        iconRes = R.drawable.ic_park,
        imageRes = R.drawable.img_park,
        recommendations = listOf(
            Recommendation(
                id = 13,
                nameRes = R.string.parques_kennedy,
                descriptionRes = R.string.parques_kennedy_desc,
                imageRes = R.drawable.img_parque_kennedy,
            ),
            Recommendation(
                id = 14,
                nameRes = R.string.parques_olivar,
                descriptionRes = R.string.parques_olivar_desc,
                imageRes = R.drawable.img_parque_olivar,
            ),
            Recommendation(
                id = 15,
                nameRes = R.string.parques_circuito_agua,
                descriptionRes = R.string.parques_circuito_agua_desc,
                imageRes = R.drawable.img_circuito_agua,
            ),
            Recommendation(
                id = 16,
                nameRes = R.string.parques_amor,
                descriptionRes = R.string.parques_amor_desc,
                imageRes = R.drawable.img_parque_amor,
            ),
        ),
    )

    private val centrosComerciales = Category(
        id = 5,
        nameRes = R.string.category_centros_comerciales,
        iconRes = R.drawable.ic_mall,
        imageRes = R.drawable.img_mall,
        recommendations = listOf(
            Recommendation(
                id = 17,
                nameRes = R.string.centros_larcomar,
                descriptionRes = R.string.centros_larcomar_desc,
                imageRes = R.drawable.img_larcomar,
            ),
            Recommendation(
                id = 18,
                nameRes = R.string.centros_jockey,
                descriptionRes = R.string.centros_jockey_desc,
                imageRes = R.drawable.img_jockey_plaza,
            ),
            Recommendation(
                id = 19,
                nameRes = R.string.centros_real_plaza,
                descriptionRes = R.string.centros_real_plaza_desc,
                imageRes = R.drawable.img_real_plaza,
            ),
            Recommendation(
                id = 20,
                nameRes = R.string.centros_plaza_norte,
                descriptionRes = R.string.centros_plaza_norte_desc,
                imageRes = R.drawable.img_plaza_norte,
            ),
        ),
    )

    private val lugaresParaNinos = Category(
        id = 6,
        nameRes = R.string.category_lugares_ninos,
        iconRes = R.drawable.ic_kids,
        imageRes = R.drawable.img_kids,
        recommendations = listOf(
            Recommendation(
                id = 21,
                nameRes = R.string.ninos_leyendas,
                descriptionRes = R.string.ninos_leyendas_desc,
                imageRes = R.drawable.img_parque_leyendas,
            ),
            Recommendation(
                id = 22,
                nameRes = R.string.ninos_coney_park,
                descriptionRes = R.string.ninos_coney_park_desc,
                imageRes = R.drawable.img_coney_park,
            ),
            Recommendation(
                id = 23,
                nameRes = R.string.ninos_amistad,
                descriptionRes = R.string.ninos_amistad_desc,
                imageRes = R.drawable.img_parque_amistad,
            ),
        ),
    )

    val categories: List<Category> = listOf(
        cafeterias,
        restaurantes,
        museos,
        parques,
        centrosComerciales,
        lugaresParaNinos,
    )
}