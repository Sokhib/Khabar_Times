package com.tora.khabartimes.data.network

import com.tora.khabartimes.data.model.PopularArticles
import com.tora.khabartimes.utils.Period
import com.tora.khabartimes.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NYTNetworkDataSource {
    suspend fun getMostPopularArticles(period: Period): Flow<Resource<PopularArticles>>
}