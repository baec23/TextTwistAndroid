package com.baec.texttwist.ui.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    var gameState by mutableStateOf(GameState())
        private set

    private val availableLetters: MutableList<Char> = mutableListOf()
    private val guessedLetters: MutableList<Char> = mutableListOf()

    var loaded = false;

    fun clickGuessedLetter(index: Int) {
        val letter = guessedLetters.removeAt(index)
        availableLetters.add(letter)
        updateGameState()
    }

    fun clickAvailableLetter(index: Int) {
        val letter = availableLetters.removeAt(index)
        guessedLetters.add(letter)
        updateGameState()
    }

    private fun updateGameState() {
        gameState = gameState.copy(
            availableLetters = availableLetters.toList(),
            guessedLetters = guessedLetters.toList()
        )
    }

    fun init()
    {
        viewModelScope.launch { loadWord() }
    }

    suspend fun loadWord() = coroutineScope {
        launch {
            delay(2000L)
            if (!loaded) {
                availableLetters.add('C')
                availableLetters.add('O')
                availableLetters.add('C')
                availableLetters.add('O')
                availableLetters.add('N')
                availableLetters.add('U')
                availableLetters.add('T')
                updateGameState()
                loaded = true;
            }
        }
    }
}