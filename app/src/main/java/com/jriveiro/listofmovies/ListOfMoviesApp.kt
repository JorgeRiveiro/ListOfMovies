package com.jriveiro.listofmovies

import android.app.Application
import androidx.room.Room
import com.jriveiro.listofmovies.framework.database.MoviesDatabase
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