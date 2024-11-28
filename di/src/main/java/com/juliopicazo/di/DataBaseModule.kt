package com.juliopicazo.di

import android.content.Context
import androidx.room.Room
import com.juliopicazo.data.database.NewsDB
import com.juliopicazo.data.database.dao.NewDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    private const val DB = "NewsDBRepository"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NewsDB {
        return Room
            .databaseBuilder(context, NewsDB::class.java, DB)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewDao(newsDB: NewsDB): NewDao = newsDB.newDao()

}
