package com.example.calculatorapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorapps.ui.Calculator
import com.example.calculatorapps.ui.CalculatorState
import com.example.calculatorapps.ui.CalculatorViewModel
import com.example.calculatorapps.ui.theme.Background
import com.example.calculatorapps.ui.theme.CalculatorAppsTheme
import com.example.calculatorapps.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppsTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                //It was private so it cannot set from outside class
//                viewModel.state =
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    onActions = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Background)
                        .padding(16.dp)
                )
            }
        }
    }
}
