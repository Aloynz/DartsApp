package com.example.dartsapp.ui

import androidx.lifecycle.ViewModel
import com.example.dartsapp.data.DartScore
import com.example.dartsapp.states.Game01State
import com.example.dartsapp.states.Ruleset01
import com.example.dartsapp.states.OutOption
import com.example.dartsapp.data.DartScore.Multiplier
import com.example.dartsapp.states.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Game01ViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(Game01State())
    val gameState: StateFlow<Game01State> = _gameState.asStateFlow()

    private val _playerStates : ArrayList<MutableStateFlow<Player>>
        = ArrayList<MutableStateFlow<Player>>(gameState.value.playerCount)
    val playerStates: ArrayList<StateFlow<Player>>
        = ArrayList<StateFlow<Player>>(gameState.value.playerCount)

    val ruleset01 = MutableStateFlow(Ruleset01()).asStateFlow()

    init {
        resetGame()
        print(gameState.value.playerCount)
    }

    fun resetGame() {
        val players = _gameState.value.players
        for (i in players.indices) {
            _playerStates.add(MutableStateFlow(Player(players[i].playerName)))
            playerStates.add(_playerStates[i].asStateFlow())
        }
    }

    fun awaitMultiplier(score: Int) {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        val dartCount = currPlayerState.value.dartCount
        if (dartCount >= 3) {
            return
        }
        currPlayerState.update { currentState ->
            currentState.copy(
                dartScore = score
            )
        }
    }

    fun applySingle() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        val dartResult = DartScore(currPlayerState.value.dartScore, Multiplier.SINGLE)
        // apply multi to dartScore
        // add dartScore to roundScore and reset dartScore
        updateRoundScore(dartResult)
    }

    fun applyDouble() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        // apply multi to dartScore
        val newDartScore = currPlayerState.value.dartScore.times(2)
        val dartResult = DartScore(currPlayerState.value.dartScore, Multiplier.DOUBLE)
        // add dartScore to roundScore and reset dartScore
        updateRoundScore(dartResult)
    }

    fun applyTriple() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        // apply multi to dartScore
        val newDartScore = currPlayerState.value.dartScore.times(3)
        val dartResult = DartScore(currPlayerState.value.dartScore, Multiplier.TRIPLE)
        // add dartScore to roundScore and reset dartScore
        updateRoundScore(dartResult)
    }

    fun applySingleBull() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        // apply multi to dartScore
        val newDartScore = if (ruleset01.value.splitBull) 25 else 50
        val dartResult = DartScore(newDartScore, Multiplier.SINGLE, true)
        // add dartScore to roundScore and reset dartScore
        updateRoundScore(dartResult)
    }

    fun applyDoubleBull() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        // apply multi to dartScore
        val dartResult = DartScore(currPlayerState.value.dartScore, Multiplier.DOUBLE, true)
        // add dartScore to roundScore and reset dartScore
        updateRoundScore(dartResult)
    }

    fun updateRoundScore(dartResult: DartScore) {
        // update dart score, round score
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]

        val newRoundScore = currPlayerState.value.roundScore.plus(dartResult.score)
        val newDartCount = currPlayerState.value.dartCount.plus(1)
        currPlayerState.update { currentState ->
            currentState.copy(
                roundScore = newRoundScore,
                dartScore = 0,
                dartCount = newDartCount
            )
        }
        // update player's score and check for checkout/bust
        val newPlayerScore = currPlayerState.value.score_01.minus(dartResult.score)
        if (newPlayerScore == 0) {
            when (ruleset01.value.outOption) {
                OutOption.DOUBLE -> {
                    if (dartResult.multiplier == Multiplier.DOUBLE) {
                        finishGame(currPlayerState)
                    } else {
                        bustRound(currPlayerState, newPlayerScore, newRoundScore)
                    }
                }
                OutOption.TRIPLE -> {
                    if (dartResult.multiplier == Multiplier.TRIPLE) {
                        finishGame(currPlayerState)
                    } else {
                        bustRound(currPlayerState, newPlayerScore, newRoundScore)
                    }
                }
                OutOption.MASTER -> {
                    if (dartResult.multiplier == Multiplier.DOUBLE ||
                            dartResult.multiplier == Multiplier.TRIPLE ||
                            dartResult.isBull) {
                        finishGame(currPlayerState)
                    } else {
                        bustRound(currPlayerState, newPlayerScore, newRoundScore)
                    }
                }
                else -> {
                    finishGame(currPlayerState)
                }
            }
        } else if (newPlayerScore < 0) {
            bustRound(currPlayerState, newPlayerScore, newRoundScore)
        } else {
            currPlayerState.update { currentState ->
                currentState.copy(
                    score_01 = newPlayerScore
                )
            }
        }

    }

    fun bustRound(currPlayerState: MutableStateFlow<Player>, bustedScore: Int, roundScore: Int) {
        currPlayerState.update { currentState ->
            currentState.copy(
                score_01 = bustedScore + roundScore,
                dartCount = 3
            )
        }
    }

    fun finishGame(currPlayerState: MutableStateFlow<Player>) {
        currPlayerState.update { currentState ->
            currentState.copy(
                score_01 = 0
            )
        }
    }

    fun changePlayer() {
        val currPlayerIndex = _gameState.value.currPlayerIndex
        val currPlayerState = _playerStates[currPlayerIndex]
        currPlayerState.update { currentState ->
            currentState.copy(
                roundScore = 0,
                dartScore = 0,
                dartCount = 0
            )
        }
        val nextPlayerIndex = (currPlayerIndex + 1) % _gameState.value.playerCount
        _gameState.update { currentState ->
            currentState.copy(
                currPlayerIndex = nextPlayerIndex,
            )
        }
    }
}

