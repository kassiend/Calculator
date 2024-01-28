import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.moriatsushi.insetsx.rememberWindowInsetsController
import com.moriatsushi.insetsx.systemBars
import ui.Content
import ui.Toolbar
import ui.components.AppColors
import ui.components.NeumorphismTheme

@Composable
fun App() {

    val isSystemInDarkTheme = isSystemInDarkTheme()
    var useDarkMode by rememberSaveable { mutableStateOf(isSystemInDarkTheme) }

    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(useDarkMode) {
        windowInsetsController?.apply {
            setStatusBarContentColor(dark = !useDarkMode)
            setNavigationBarsContentColor(dark = !useDarkMode)
        }
    }

    NeumorphismTheme(
        colorScheme = if (useDarkMode) darkColorScheme().copy(
            background = AppColors.Dark.Background,
            onTertiary = AppColors.Dark.TextColor
        ) else lightColorScheme().copy(
            background = AppColors.Light.Background,
            onTertiary = AppColors.Light.TextColor
        )
    ) {
        key(useDarkMode) {
            Calculator(
                onToggleDarkMode = { useDarkMode = !useDarkMode }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Calculator(
    modifier: Modifier = Modifier,
    onToggleDarkMode: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Toolbar(onToggleDarkMode = onToggleDarkMode)
        },
        contentWindowInsets = WindowInsets.systemBars
    ) {
        Content(
            modifier = Modifier
                .padding(it)
                .consumeWindowInsets(it)
        )
    }
}