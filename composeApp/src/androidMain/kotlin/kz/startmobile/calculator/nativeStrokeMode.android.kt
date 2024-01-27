package kz.startmobile.calculator

import androidx.compose.ui.graphics.NativePaint

internal actual fun NativePaint.setStrokeMode() {
    this.style = android.graphics.Paint.Style.STROKE
}