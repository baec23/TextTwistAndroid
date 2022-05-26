package com.baec.texttwist.data

interface WordRepository {
    suspend fun getRandomWord(): Word?
}