package com.baec.texttwist.data

class WordRepositoryImpl(private val dao: WordDao) : WordRepository {
    override suspend fun getRandomWord(): Word? {
        return dao.getRandomWord()
    }
}