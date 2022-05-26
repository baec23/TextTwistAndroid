package com.baec.texttwist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    val solutions: List<String>,
    val word: String,
    @PrimaryKey val id: Int? = null
)
