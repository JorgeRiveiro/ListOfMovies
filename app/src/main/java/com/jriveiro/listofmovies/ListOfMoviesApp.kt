package com.jriveiro.listofmovies

import android.app.Application
import androidx.room.Room
import com.jriveiro.core.MoviesDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ListOfMoviesApp: Application(){

    lateinit var db: com.jriveiro.core.MoviesDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this, com.jriveiro.core.MoviesDatabase::class.java, "movies.db")
            .build()
    }
}