package com.example.dartsapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dartsapp.states.Player

@Preview
@Composable
fun Game01Screen(
    modifier: Modifier = Modifier,
    gameViewModel: Game01ViewModel = viewModel()
) {
    val gameState by gameViewModel.gameState.collectAsState()
    val playerStates: ArrayList<State<Player>> = ArrayList<State<Player>>(gameState.playerCount)
    for (i in 0 until gameState.playerCount) {
        playerStates.add(gameViewModel.playerStates[i].collectAsState())
    }
    val player1State by gameViewModel.playerStates[0].collectAsState()
    val player2State by gameViewModel.playerStates[1].collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Game01Status(
            player1Score = player1State.score_01,
            player2Score = player2State.score_01,
            currentPlayer = gameState.currPlayerIndex,
            roundScore = playerStates[gameState.currPlayerIndex].value.roundScore
        )
        Game01Controller(gameViewModel = gameViewModel)
    }
}

@Composable
fun Game01Status(
    modifier: Modifier = Modifier,
    player1Score: Int,
    player2Score: Int,
    currentPlayer: Int,
    roundScore: Int
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
            Text(
                text = player1Score.toString(),
                fontSize = 30.sp,
                color = Color.Green
            )
            Text(
                text = roundScore.toString(),
                fontSize = 30.sp,
                color = Color.Black
            )
            Text(
                text = player2Score.toString(),
                fontSize = 30.sp,
                color = Color.Red
            )
        }
    }
}