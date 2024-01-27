package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors {
    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)

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
    fun lightShadow() = if (androidx.compose.material.MaterialTheme.colors.isLight) Light.LightShadow else Dark.LightShadow

    @Composable
    fun darkShadow() = if (androidx.compose.material.MaterialTheme.colors.isLight) Light.DarkShadow else Dark.DarkShadow

}