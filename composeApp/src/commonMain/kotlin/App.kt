import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moriatsushi.insetsx.ExperimentalSoftwareKeyboardApi
import com.moriatsushi.insetsx.rememberWindowInsetsController
import com.moriatsushi.insetsx.safeArea
import com.moriatsushi.insetsx.systemBars
import nuemorphism.LightSource
import nuemorphism.neu
import nuemorphism.shape.Flat
import nuemorphism.shape.Pressed
import nuemorphism.shape.RoundedCorner
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.AppColors
import ui.NeumorphismTheme
import ui.Nightlight

@OptIn(ExperimentalResourceApi::class)
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

    var isDarkTheme by remember {
        mutableStateOf(true)
    }

    NeumorphismTheme(isDarkTheme = isDarkTheme) {
        Surface(modifier = Modifier.fillMaxSize()) {

        }
        Calculator(
            modifier = Modifier.fillMaxSize(),
        ) {
            isDarkTheme = !isDarkTheme
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    onToggleDarkMode: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = { Text("NeuroCalculator") },
        actions = {
            IconButton(onClick = onToggleDarkMode) {
                Icon(
                    imageVector = Icons.Filled.Nightlight,
                    contentDescription = null
                )
            }
        },
        windowInsets = WindowInsets.safeArea.only(
            WindowInsetsSides.Top + WindowInsetsSides.Horizontal
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSoftwareKeyboardApi::class)
@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    var formulaText by mutableStateOf("")

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(46.dp)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = 6.dp,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(RoundedCorner(24.dp)),
                ),
        ) {

        }
    }
}