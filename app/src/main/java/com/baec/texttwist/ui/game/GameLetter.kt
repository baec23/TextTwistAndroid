package com.baec.texttwist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baec.texttwist.ui.theme.DarkBlue
import com.baec.texttwist.ui.theme.LightGrey

@Composable
fun GameLetter(
    letter: Char,
    modifier: Modifier,
    index: Int,
    onClick: (Int) -> Unit,
    size: Dp = 50.dp,
    fontSize: TextUnit = 24.sp,
              )
{
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(color = LightGrey)
            .clickable { onClick(index) }
            .then(modifier)
       ) {
        Text(
            text = letter.toString(),
            fontSize = fontSize,
            color = DarkBlue,
            modifier = modifier
            )
    }
}