package com.example.dartsapp.states

data class Ruleset01(
    val roundLimit: Int = 15,
    val roundNumber: Int = 1,

    val bullScore: Int = 25,
    val splitBull: Boolean = false,

    val inOption: InOption = InOption.OPEN,
    val outOption: OutOption = OutOption.OPEN,

    val shanghai: Boolean = false
)

enum class InOption { OPEN, DOUBLE, TRIPLE, MASTER }
enum class OutOption { OPEN, DOUBLE, TRIPLE, MASTER }
