package com.jriveiro.listofmovies.di

import coil.decode.DataSource
import com.jriveiro.data.datasource.LocationDataSource
import com.jriveiro.data.datasource.MoviesRemoteDataSource
import com.jriveiro.data.datasource.RegionDataSource
import com.jriveiro.region.GeocoderRegionDataSource
import com.jriveiro.movie.database.MoviesRoomDataSource
import com.jriveiro.movie.network.MoviesServerDataSource
import com.jriveiro.region.PlayServicesLocationDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindMoviesLocalDataSource(
        impl: com.jriveiro.movie.database.MoviesRoomDataSource
    ): DataSource

    @Binds
    abstract fun bindMoviesRemoteDataSource(
        impl: com.jriveiro.movie.network.MoviesServerDataSource
    ): MoviesRemoteDataSource

    @Binds
    abstract fun bindRegionDataSource(
        impl: com.jriveiro.region.GeocoderRegionDataSource
    ): RegionDataSource

    @Binds
    abstract fun bindLocalDataSource(
        impl: com.jriveiro.region.PlayServicesLocationDataSource
    ): LocationDataSource
}