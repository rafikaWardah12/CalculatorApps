package com.example.calculatorapps.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculatorapps.ui.component.CalculatorButton
import com.example.calculatorapps.ui.theme.LightGrey
import com.example.calculatorapps.ui.theme.MediumGray
import com.example.calculatorapps.ui.theme.Pink

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onActions: (CalculatorActions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                maxLines = 2,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGrey)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onActions(CalculatorActions.Clear)
                    }
                )

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Pink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(7))
                    }
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(8))
                    }
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(10))
                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(Pink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperation.Multiple))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(4))
                    }
                )

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(5))
                    }
                )

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(6))
                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Pink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(1))
                    }
                )

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(2))
                    }
                )

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(3))
                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Pink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onActions(CalculatorActions.Number(0))
                    }
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(MediumGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Decimal)
                    }
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Pink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}