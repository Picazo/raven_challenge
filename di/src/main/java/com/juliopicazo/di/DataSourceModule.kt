package com.juliopicazo.di

import com.juliopicazo.data.database.dao.NewDao
import com.juliopicazo.data.networking.NewsApi
import com.juliopicazo.data.repository.LocalDataSourceImpl
import com.juliopicazo.data.repository.RemoteDataSourceImpl
import com.juliopicazo.domain.datasource.LocalDataSource
import com.juliopicazo.domain.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(newsApi: NewsApi): RemoteDataSource =
        RemoteDataSourceImpl(newsApi)

    @Singleton
    @Provides
    fun provideLocalDataSource(newDao: NewDao): LocalDataSource =
        LocalDataSourceImpl(newDao)

}
