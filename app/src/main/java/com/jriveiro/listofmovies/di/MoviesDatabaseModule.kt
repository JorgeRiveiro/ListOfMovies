package com.jriveiro.listofmovies.di

import android.content.Context
import androidx.room.Room
import com.jriveiro.movie.database.MoviesDao
import com.jriveiro.core.MoviesDatabase
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
    fun provideDatabase(@ApplicationContext appContext: Context): com.jriveiro.core.MoviesDatabase =
        Room.databaseBuilder(appContext, com.jriveiro.core.MoviesDatabase::class.java, "movies.db").fallbackToDestructiveMigration().build()

    @Provides
    fun provideMoviesDao(db: com.jriveiro.core.MoviesDatabase): com.jriveiro.movie.database.MoviesDao = db.moviesDao()
}
