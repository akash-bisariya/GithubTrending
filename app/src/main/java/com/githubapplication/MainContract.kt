package com.githubapplication

interface MainContract {

    interface MainView {

        fun requestDataFromServer(language: String)

        fun onDestroy()

    }

    interface MainPresenter {

        fun showProgress()

        fun hideProgress()

        fun setData()

        fun onFailure()

    }

    interface MainInteractor {

        fun getDataFromServer(onFinishedListener: OnFinishedListener, language: String)

        fun getTrendingRepositories(
            onFinishedListener: OnFinishedListener
        )

        interface OnFinishedListener {

            fun onSuccess()

            fun onFailure()

        }

    }
}