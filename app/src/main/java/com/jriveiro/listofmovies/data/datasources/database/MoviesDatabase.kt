package com.jriveiro.listofmovies.data.datasources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jriveiro.listofmovies.domain.Movie

@Database(entities = [DbMovie::class], version = 2, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}