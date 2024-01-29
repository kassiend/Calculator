package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    text: Char,
    onClick: (char: Char) -> Unit
) {
    Box(
        modifier = Modifier
            .widthIn()
            .heightIn()
            .bounceClick()
            .then(modifier)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() } // This is mandatory
            ) {
                onClick(text)
            }
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
                    text = text.toString(),
                    color = AppColors.CalculatorNumPadColor,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
