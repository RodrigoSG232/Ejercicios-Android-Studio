package com.example.mycity.ui

import android.content.res.Resources
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

/**
 * Carga una imagen de recurso decodificándola a un tamaño máximo, en lugar de
 * decodificarla completa en la memoria. Las fotos de cámara (4000px+ en ARGB)
 * pueden ocupar decenas de MB; reducirlas evita lag y cortes de memoria.
 *
 * Si el recurso no es una imagen de mapa de bits (por ejemplo, un vector de
 * relleno), vuelve al cargador normal.
 */
@Composable
fun rememberScaledImagePainter(
    imageRes: Int,
    maxWidthPx: Int = 1080,
): Painter {
    val context = LocalContext.current
    val fallbackPainter = painterResource(imageRes)
    return remember(imageRes, maxWidthPx) {
        val bitmap = decodeDownscaledBitmap(context.resources, imageRes, maxWidthPx)
        if (bitmap != null) {
            BitmapPainter(bitmap, filterQuality = androidx.compose.ui.graphics.FilterQuality.High)
        } else {
            fallbackPainter
        }
    }
}

/**
 * Decodifica un recurso de imagen reduciéndolo con [BitmapFactory.Options.inSampleSize]
 * hasta que su ancho sea menor o igual a [maxWidthPx]. Devuelve null si el recurso
 * no es un mapa de bits decodificable (ejemplo: un vector XML o un archivo inválido).
 */
private fun decodeDownscaledBitmap(
    resources: Resources,
    imageRes: Int,
    maxWidthPx: Int,
): ImageBitmap? {
    val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    BitmapFactory.decodeResource(resources, imageRes, bounds)

    val width = bounds.outWidth
    val height = bounds.outHeight
    if (width <= 0 || height <= 0) return null

    var sampleSize = 1
    while (width / (sampleSize * 2) >= maxWidthPx) {
        sampleSize *= 2
    }

    val options = BitmapFactory.Options().apply { inSampleSize = sampleSize }
    val bitmap = BitmapFactory.decodeResource(resources, imageRes, options) ?: return null
    return bitmap.asImageBitmap()
}