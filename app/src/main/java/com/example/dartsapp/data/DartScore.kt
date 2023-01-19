package com.example.dartsapp.data

class DartScore(
    number: Int,
    multiplier: Multiplier,
    isBull: Boolean = false
) {
    enum class Multiplier { SINGLE, DOUBLE, TRIPLE }
    val number = number
    val multiplier = multiplier
    val isBull = isBull
    var score: Int = when (multiplier) {
        Multiplier.SINGLE -> number
        Multiplier.DOUBLE -> number * 2
        Multiplier.TRIPLE -> number * 3
    }

    override fun toString(): String {
        if (this.number == 25 || this.number == 50) {
            return this.multiplier.toString() + " BULL"
        }
        return this.multiplier.toString() + " " + this.number.toString()
    }
}