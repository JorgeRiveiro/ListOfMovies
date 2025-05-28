package com.jriveiro.listofmovies.data.datasources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jriveiro.listofmovies.data.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}