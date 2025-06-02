package com.jriveiro.core

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbMovie::class], version = 2, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}