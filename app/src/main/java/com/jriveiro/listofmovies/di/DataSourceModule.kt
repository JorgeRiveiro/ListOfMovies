package com.jriveiro.listofmovies.di

import coil.decode.DataSource
import com.jriveiro.data.datasource.LocationDataSource
import com.jriveiro.data.datasource.MoviesRemoteDataSource
import com.jriveiro.data.datasource.RegionDataSource
import com.jriveiro.listofmovies.framework.GeocoderRegionDataSource
import com.jriveiro.listofmovies.framework.MoviesRoomDataSource
import com.jriveiro.listofmovies.framework.MoviesServerDataSource
import com.jriveiro.listofmovies.framework.PlayServicesLocationDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindMoviesLocalDataSource(
        impl: MoviesRoomDataSource
    ): DataSource

    @Binds
    abstract fun bindMoviesRemoteDataSource(
        impl: MoviesServerDataSource
    ): MoviesRemoteDataSource

    @Binds
    abstract fun bindRegionDataSource(
        impl: GeocoderRegionDataSource
    ): RegionDataSource

    @Binds
    abstract fun bindLocalDataSource(
        impl: PlayServicesLocationDataSource
    ): LocationDataSource
}