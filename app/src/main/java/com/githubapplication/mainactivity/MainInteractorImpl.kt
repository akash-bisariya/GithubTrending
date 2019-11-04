package com.githubapplication

import android.content.Context
import android.util.Log
import com.TrendingRepositories
import com.githubapplication.utils.CommonUtil
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractorImpl(val context: Context) : MainContract.MainInteractor {
    private val BASE_URL = "https://github-trending-api.now.sh/"
    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(context.cacheDir, cacheSize)

    override fun getTrendingRepositories(onFinishedListener: MainContract.MainInteractor.OnFinishedListener, language: String) {

        val okHttpClient = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (CommonUtil.hasNetwork(context)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val getGithubService:GithubService = retrofit.create(GithubService::class.java)

        val call: Call<ArrayList<TrendingRepositories>> = getGithubService.getGithubData(language,"weekly")

        Log.d("URL Called", ""+call.request().url());

        call.enqueue(object : Callback<ArrayList<TrendingRepositories>> {
            override fun onFailure(call: Call<ArrayList<TrendingRepositories>>, t: Throwable) {
                onFinishedListener.onFailure()
            }

            override fun onResponse(call: Call<ArrayList<TrendingRepositories>>, response: Response<ArrayList<TrendingRepositories>>) {
                response.body()?.let { onFinishedListener.onSuccess(it) }
            }

        })
    }


}