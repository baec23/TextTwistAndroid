package com.baec.texttwist.di

import android.app.Application
import androidx.room.Room
import com.baec.texttwist.data.WordDatabase
import com.baec.texttwist.data.WordRepository
import com.baec.texttwist.data.WordRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWordDatabase(app: Application): WordDatabase {
        return Room.databaseBuilder(
            app,
            WordDatabase::class.java,
            "word_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWordRepository(db: WordDatabase): WordRepository {
        return WordRepositoryImpl(db.dao)
    }
}