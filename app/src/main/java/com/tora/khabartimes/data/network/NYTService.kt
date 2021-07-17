package com.tora.khabartimes.data.network

import com.tora.khabartimes.data.model.PopularArticles
import retrofit2.http.GET
import retrofit2.http.Path

interface NYTService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/{days}.json")
    suspend fun fetchMostPopularArticles(@Path("days") days: Int): PopularArticles

}