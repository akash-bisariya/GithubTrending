package com.githubapplication.mainactivity

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

        fun onRepositoryItemClick(url: String)

    }

    interface MainInteractor {

        fun getTrendingRepositories(onFinishedListener: OnFinishedListener, language: String)

        interface OnFinishedListener {

            fun onSuccess(trendingRepositories: ArrayList<TrendingRepositories>)

            fun onFailure()

        }

    }
}