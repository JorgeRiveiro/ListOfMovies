package com.jriveiro.listofmovies.di

import com.jriveiro.listofmovies.framework.remote.MoviesClient
import com.jriveiro.listofmovies.framework.remote.MoviesService
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
    fun provideMoviesClient(): MoviesClient = MoviesClient

    @Provides
    @Singleton
    fun provideMoviesService(moviesClient: MoviesClient): MoviesService =
        moviesClient.instance
}