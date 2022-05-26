package com.baec.texttwist.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM word ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomWord(): Word?

}