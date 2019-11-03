package com.githubapplication

import android.util.Log
import com.TrendingRepositories
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractorImpl : MainContract.MainInteractor {

    private val BASE_URL = "https://github-trending-api.now.sh/developers/"





    override fun getDataFromServer(onFinishedListener: MainContract.MainInteractor.OnFinishedListener, language: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getGithubService:GithubService = retrofit.create(GithubService::class.java)

        val call: Call<TrendingRepositories> = getGithubService.getGithubData(language,"weekly")

        Log.d("URL Called", ""+call.request().url());

    }

    override fun getTrendingRepositories(onFinishedListener: MainContract.MainInteractor.OnFinishedListener) {

    }
}