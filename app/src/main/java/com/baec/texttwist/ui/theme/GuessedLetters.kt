package com.baec.texttwist.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baec.texttwist.ui.game.GameState
import com.baec.texttwist.ui.GameLetter

@Composable
fun GuessedLetters(
    gameState: GameState,
    modifier: Modifier,
    onClick: (Int) -> Unit,
) {
    Box(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .then(modifier)
    )
    {
        Row(
                modifier = Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (i in gameState.guessedLetters.indices) {
                GameLetter(letter = gameState.guessedLetters[i],
                        modifier = modifier,
                        index = i,
                        onClick = onClick
                )
            }
        }
    }
}