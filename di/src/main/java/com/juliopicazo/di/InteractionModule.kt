package com.juliopicazo.di

import com.juliopicazo.domain.interactor.DeleteNewUseCase
import com.juliopicazo.domain.interactor.DeleteNewUseCaseImpl
import com.juliopicazo.domain.interactor.GetNewsUseCase
import com.juliopicazo.domain.interactor.GetNewsUseCaseImpl
import com.juliopicazo.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractionModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase =
        GetNewsUseCaseImpl(newsRepository)

    @Provides
    fun provideDeleteNewUseCase(newsRepository: NewsRepository): DeleteNewUseCase =
        DeleteNewUseCaseImpl(newsRepository)

}
