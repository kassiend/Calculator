package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nuemorphism.LightSource
import nuemorphism.neu
import nuemorphism.shape.Flat
import nuemorphism.shape.RoundedCorner
import ui.components.AppColors
import ui.components.bounceClick

@Composable
fun Button(
    modifier: Modifier = Modifier
        .widthIn()
        .heightIn(),
    text: String = "0",
) {
    Box(
        modifier = Modifier
            .widthIn()
            .heightIn()
            .bounceClick()
            .then(modifier)
    ) {
        Card(
            modifier = Modifier
                .widthIn(67.dp)
                .heightIn(67.dp)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = 6.dp,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(RoundedCorner(12.dp)),
                ),
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = text,
                    color = AppColors.CalculatorNumPadColor,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
