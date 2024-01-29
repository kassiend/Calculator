package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.startmobile.calculator.font
import nuemorphism.LightSource
import nuemorphism.neu
import nuemorphism.shape.Flat
import nuemorphism.shape.RoundedCorner
import ui.components.AppColors
import ui.components.AppColors.CalculatorBackground

@Composable
fun Content(
    modifier: Modifier = Modifier,
) {
    val vm: ViewModel = remember {
        ViewModel()
    }

    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        HeadContent(
            resultTextProvider = { vm.resultText.value.ifBlank { "" } }
        )
        ButtonContent(
            onClick = {
                vm.click(it)
            }
        )
    }
}

@Composable
fun HeadContent(
    resultTextProvider: () -> String,
) {
    Card(
        modifier = Modifier
            .width(356.dp)
            .height(110.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = 6.dp,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(RoundedCorner(10.dp)),
            ),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .background(CalculatorBackground, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "888888888",
                fontFamily = FontFamily(
                    font("Digital", "digital_mono", FontWeight.Normal, FontStyle.Normal)
                ),
                fontSize = 58.sp,
                color = AppColors.CalculatorTextHintColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .align(Alignment.Center)
                    .heightIn(),
                textAlign = TextAlign.End
            )
            Text(
                text = resultTextProvider.invoke(),
                fontFamily = FontFamily(
                    font("Digital", "digital_mono", FontWeight.Normal, FontStyle.Normal)
                ),
                fontSize = 58.sp,
                color = AppColors.CalculatorTextInputColor,
                modifier = Modifier
                    .padding(start = 12.dp, end = 11.dp)
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .heightIn(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun ButtonContent(
    onClick: (char: Char) -> Unit
) {
    val itemsList = listOf('C', '^', '%', '÷', '7', '8', '9', '*', '4', '5', '6', '-', '1', '2', '3', '+', '⌫', '0', '.', '=')
    LazyVerticalGrid(
        modifier = Modifier
            .widthIn(min = 360.dp)
            .heightIn(min = 520.dp),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
        columns = GridCells.Adaptive(70.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(itemsList) { _, item ->
            Button(
                modifier = Modifier
                    .widthIn()
                    .heightIn(),
                text = item
            ) {
                onClick(it)
            }
        }

    }
}