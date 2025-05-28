package com.jriveiro.listofmovies.di

import android.content.Context
import androidx.room.Room
import com.jriveiro.listofmovies.data.datasources.database.MoviesDao
import com.jriveiro.listofmovies.data.datasources.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MoviesDatabase =
        Room.databaseBuilder(appContext, MoviesDatabase::class.java, "movies.db").fallbackToDestructiveMigration().build()

    @Provides
    fun provideMoviesDao(db: MoviesDatabase): MoviesDao = db.moviesDao()
}
