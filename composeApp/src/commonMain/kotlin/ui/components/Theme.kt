package ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = AppColors.Purple200,
    onPrimary = Color.White,

    secondary = AppColors.Purple500,

    background = AppColors.Dark.Background,
    onBackground = Color.White,
    surface = AppColors.Dark.Background,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = AppColors.Purple200,
    onPrimary = Color.Black,

    secondary = AppColors.Purple500,

    background = AppColors.Light.Background,
    onBackground = Color.Black,
    surface = AppColors.Light.Background,
    onSurface = Color.Black,
)



@Composable
fun NeumorphismTheme(colorScheme: ColorScheme, content: @Composable() () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            background = colorScheme.background,
            onBackground = colorScheme.onBackground,
            tertiary = colorScheme.onTertiary
        ),
        shapes = MaterialTheme.shapes,
        content = content
    )
}