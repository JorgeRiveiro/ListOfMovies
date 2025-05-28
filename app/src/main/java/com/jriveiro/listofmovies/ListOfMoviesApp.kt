package com.jriveiro.listofmovies

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jriveiro.listofmovies.data.datasources.database.MoviesDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ListOfMoviesApp: Application(){

    lateinit var db: MoviesDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this, MoviesDatabase::class.java, "movies.db")
            .build()
    }
}