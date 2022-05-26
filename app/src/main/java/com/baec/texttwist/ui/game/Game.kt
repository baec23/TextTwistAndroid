package com.baec.texttwist.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.baec.texttwist.ui.AvailableLetters
import com.baec.texttwist.ui.theme.GuessedLetters

@Composable
fun Game(
    viewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    viewModel.init()
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row() {
                GuessedLetters(
                    viewModel.gameState,
                    modifier = modifier,
                    onClick = viewModel::clickGuessedLetter
                )
            }
            Row() {
                AvailableLetters(
                    viewModel.gameState,
                    modifier = modifier,
                    onClick = viewModel::clickAvailableLetter
                )
            }
        }
    }
}