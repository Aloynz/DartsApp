package com.example.dartsapp.states

import com.example.dartsapp.data.DartScore

data class Player(
    var playerName: String,

    var score_01: Int = 501,
    var score_cr: Int = 0,
    var score_cu: Int = 0,
    var threeDarts:ArrayList<DartScore> = ArrayList<DartScore>(3),

    var roundScore: Int = 0,
    var dartScore: Int = 0,
    var dartCount: Int = 0
) {
    fun reset() {
        score_01 = 501
        score_cr = 0
        score_cu = 0
        threeDarts = ArrayList<DartScore>(3)
        roundScore = 0
        dartScore = 0
        dartCount = 0
    }
}
