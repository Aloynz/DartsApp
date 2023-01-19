package com.example.dartsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.dartsapp.R

@Composable
fun Game01Controller(
    modifier : Modifier = Modifier,
    gameViewModel: Game01ViewModel
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.33f),
                onClick = {
                    gameViewModel.awaitMultiplier(25)
                    gameViewModel.applySingleBull()}) {
                    Text(stringResource(R.string.button_sbull))
                }
            Button(
                modifier = Modifier.weight(0.33f),
                onClick = {
                    gameViewModel.awaitMultiplier(25)
                    gameViewModel.applyDoubleBull()}) {
                Text(stringResource(R.string.button_dbull))
            }
            Button(
                modifier = Modifier.weight(0.33f),
                onClick = {
                    gameViewModel.awaitMultiplier(0)
                    gameViewModel.applySingle()}) {
                Text(stringResource(R.string.button_miss))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(1) }) {
                Text(stringResource(R.string.button_1))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(2) }) {
                Text(stringResource(R.string.button_2))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(3) }) {
                Text(stringResource(R.string.button_3))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(4) }) {
                Text(stringResource(R.string.button_4))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(5) }) {
                Text(stringResource(R.string.button_5))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(6) }) {
                Text(stringResource(R.string.button_6))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(7) }) {
                Text(stringResource(R.string.button_7))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(8) }) {
                Text(stringResource(R.string.button_8))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(9) }) {
                Text(stringResource(R.string.button_9))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(10) }) {
                Text(stringResource(R.string.button_10))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(11) }) {
                Text(stringResource(R.string.button_11))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(12) }) {
                Text(stringResource(R.string.button_12))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(13) }) {
                Text(stringResource(R.string.button_13))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(14) }) {
                Text(stringResource(R.string.button_14))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(15) }) {
                Text(stringResource(R.string.button_15))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(16) }) {
                Text(stringResource(R.string.button_16))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(17) }) {
                Text(stringResource(R.string.button_17))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(18) }) {
                Text(stringResource(R.string.button_18))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(19) }) {
                Text(stringResource(R.string.button_19))
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { gameViewModel.awaitMultiplier(20) }) {
                Text(stringResource(R.string.button_20))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.weight(0.25f),
                onClick = { gameViewModel.applySingle() }) {
                Text(stringResource(R.string.button_single))
            }
            Button(
                modifier = Modifier.weight(0.25f),
                onClick = { gameViewModel.applyDouble() }) {
                Text(stringResource(R.string.button_double))
            }
            Button(
                modifier = Modifier.weight(0.25f),
                onClick = { gameViewModel.applyTriple() }) {
                Text(stringResource(R.string.button_triple))
            }
            Button(
                modifier = Modifier.weight(0.25f),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                onClick = { gameViewModel.changePlayer() }) {
                Text(stringResource(R.string.button_change))
            }
        }
    }
}

/*
@Composable
fun Game_501_Controller(
    modifier : Modifier = Modifier,
    gameViewModel: Game501ViewModel
) {
    ButtonRow(
        listOf(stringResource(R.string.button_sbull),
            stringResource(R.string.button_dbull),
            stringResource(R.string.button_miss)),
        listOf(0.33f, 0.33f, 0.33f)
    )
    ButtonRow(
        listOf(stringResource(R.string.button_1),
            stringResource(R.string.button_2),
            stringResource(R.string.button_3),
            stringResource(R.string.button_4),
            stringResource(R.string.button_5)),
        listOf(0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
    )
    ButtonRow(
        listOf(stringResource(R.string.button_6),
            stringResource(R.string.button_7),
            stringResource(R.string.button_8),
            stringResource(R.string.button_9),
            stringResource(R.string.button_10)),
        listOf(0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
    )
    ButtonRow(
        listOf(stringResource(R.string.button_11),
            stringResource(R.string.button_12),
            stringResource(R.string.button_13),
            stringResource(R.string.button_14),
            stringResource(R.string.button_15)),
        listOf(0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
    )
    ButtonRow(
        listOf(stringResource(R.string.button_16),
            stringResource(R.string.button_17),
            stringResource(R.string.button_18),
            stringResource(R.string.button_19),
            stringResource(R.string.button_20)),
        listOf(0.2f, 0.2f, 0.2f, 0.2f, 0.2f)
    )
    ButtonRow(
        listOf(stringResource(R.string.button_single),
            stringResource(R.string.button_double),
            stringResource(R.string.button_triple)),
        listOf(0.33f, 0.33f, 0.33f)
    )
}

@Composable
fun ButtonRow(
    words: List<String>,
    weights: List<Float>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (i in words.indices) {
            Button(
                onClick = {},
                modifier = Modifier.weight(weights[i])
            ) {
                Text(words[i])
            }
        }
    }
}
 */