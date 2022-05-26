package com.baec.texttwist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baec.texttwist.ui.game.GameState

@Composable
fun AvailableLetters(
    gameState: GameState,
    modifier: Modifier,
    onClick: (Int) -> Unit,
) {
    Box(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .then(modifier)
    )
    {
        Row(
                modifier = Modifier
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in gameState.availableLetters.indices) {
                GameLetter(letter = gameState.availableLetters[i],
                        modifier = modifier,
                        index = i,
                        onClick = onClick
                )
            }
        }
    }
}