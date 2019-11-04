package com.githubapplication

import com.TrendingRepositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("developers")
    fun getGithubData(@Query("language") language: String, @Query("since") since: String): Call<ArrayList<TrendingRepositories>>
}