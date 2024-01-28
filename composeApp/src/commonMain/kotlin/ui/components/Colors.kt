package ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

object AppColors {
    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)

    val CalculatorTextHintColor = Color(0x263F474E)
    val CalculatorTextInputColor = Color(0xFF3F474E)
    val CalculatorBackground = Color(0xFFA5A5A5)

    object Light {
        val Background = Color(0xFFDCDCDC)
        val LightShadow = Color(0xFFFFFFFF)
        val DarkShadow = Color(0xFFA8B5C7)
        val TextColor = Color.Black
    }

    object Dark {
        val Background = Color(0xFF303234)
        val LightShadow = Color(0x66494949)
        val DarkShadow = Color(0x66000000)
        val TextColor = Color.White
    }

    @Composable
    fun ColorScheme.isLight() = this.background.luminance() > 0.5

    @Composable
    fun lightShadow() = if (MaterialTheme.colorScheme.isLight()) Light.LightShadow else Dark.LightShadow

    @Composable
    fun darkShadow() = if (MaterialTheme.colorScheme.isLight()) Light.DarkShadow else Dark.DarkShadow

}


