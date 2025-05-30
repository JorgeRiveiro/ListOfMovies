package com.jriveiro.data.datasource


const val DEFAULT_REGION = "ES"

interface RegionDataSource {
    suspend fun findLastRegion(): String
}
