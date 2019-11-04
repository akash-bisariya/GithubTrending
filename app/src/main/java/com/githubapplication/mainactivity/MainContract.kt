package com.githubapplication

import com.TrendingRepositories

interface MainContract {

    interface MainPresenter {

        fun requestDataFromServer(language: String)

        fun onDestroy()

    }

    interface MainView {

        fun showProgress()

        fun hideProgress()

        fun setData(trendingRepositories: ArrayList<TrendingRepositories>)

        fun onFailure()

    }

    interface MainInteractor {

        fun getTrendingRepositories(onFinishedListener: OnFinishedListener, language: String)

        interface OnFinishedListener {

            fun onSuccess(trendingRepositories: ArrayList<TrendingRepositories>)

            fun onFailure()

        }

    }
}