package com.example.dartsapp.states

data class Game01State(
    val playerCount: Int = 2,
    val players: ArrayList<Player> =
        arrayListOf<Player>(Player("doggo"), Player("abbb")),
    val currPlayerIndex: Int = 0
)
