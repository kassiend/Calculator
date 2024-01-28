package kz.startmobile.calculator

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Typeface
import org.jetbrains.skia.FontStyle
import org.jetbrains.skia.Typeface

actual val digitalFontFamily: FontFamily
    get() = FontFamily(
        Typeface(loadCustomFont("digital")),
    )

//TODO Required here list of fonts, but only one font included
private fun loadCustomFont(name: String): Typeface {
    return Typeface.makeFromName(name, FontStyle.NORMAL)
}