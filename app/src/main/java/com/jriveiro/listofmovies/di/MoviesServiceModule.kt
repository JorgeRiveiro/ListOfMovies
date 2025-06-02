package com.jriveiro.listofmovies.di

import com.jriveiro.core.MoviesClient
import com.jriveiro.movie.network.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesServiceModule {

    @Provides
    @Singleton
    fun provideMoviesClient(): com.jriveiro.core.MoviesClient = com.jriveiro.core.MoviesClient

    @Provides
    @Singleton
    fun provideMoviesService(moviesClient: com.jriveiro.core.MoviesClient): com.jriveiro.movie.network.MoviesService =
        moviesClient.instance
}