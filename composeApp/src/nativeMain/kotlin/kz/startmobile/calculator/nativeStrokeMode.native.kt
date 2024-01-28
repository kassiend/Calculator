package kz.startmobile.calculator

import androidx.compose.ui.graphics.NativePaint
import org.jetbrains.skia.PaintMode

internal actual fun NativePaint.setStrokeMode() {
    this.mode = PaintMode.STROKE
}