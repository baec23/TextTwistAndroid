package com.baec.texttwist.ui.game

data class GameState(
    val guessedLetters: List<Char> = emptyList(),
    val availableLetters: List<Char> = emptyList(),
)