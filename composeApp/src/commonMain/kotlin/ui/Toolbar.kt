package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.moriatsushi.insetsx.safeArea
import ui.components.Nightlight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    onToggleDarkMode: () -> Unit,
) {
    TopAppBar(
        modifier = modifier.background(Color.Transparent),
        title = { },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.0f)),
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