package kz.startmobile.calculator

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.NativePaint

internal actual fun NativePaint.setMaskFilterRadius(blurRadius: Float) {
    this.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
}