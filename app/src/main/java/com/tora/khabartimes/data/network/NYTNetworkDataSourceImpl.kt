package com.tora.khabartimes.data.network

import com.tora.khabartimes.utils.Period
import com.tora.khabartimes.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class NYTNetworkDataSourceImpl @Inject constructor(private val nytService: NYTService) :
    NYTNetworkDataSource {

    override suspend fun getMostPopularArticles(period: Period) = flow {
        try {
            val popularArticles = nytService.fetchMostPopularArticles(period.days)
            emit(Resource.success(popularArticles))
        } catch (e: Exception) {
            emit(
                Resource.error(e.message ?: "Error getting popular articles", null)
            )
        }
    }.onStart {
        emit(Resource.loading(null))
    }
}