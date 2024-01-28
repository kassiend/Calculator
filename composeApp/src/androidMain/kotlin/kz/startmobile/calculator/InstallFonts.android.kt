package kz.startmobile.calculator

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

actual val digitalFontFamily: FontFamily
    get() = FontFamily(
        fonts = listOf(
                Font(R.font.digital),
            )
    )