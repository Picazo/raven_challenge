package com.juliopicazo.di

import com.juliopicazo.data.repository.NewsRepositoryImpl
import com.juliopicazo.data.utils.NetworkHelper
import com.juliopicazo.domain.datasource.LocalDataSource
import com.juliopicazo.domain.datasource.RemoteDataSource
import com.juliopicazo.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        networkHelper: NetworkHelper,
    ): NewsRepository =
        NewsRepositoryImpl(remoteDataSource, localDataSource, networkHelper)
}
