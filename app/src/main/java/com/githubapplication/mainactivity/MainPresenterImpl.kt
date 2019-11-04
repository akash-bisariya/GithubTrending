package com.githubapplication.mainactivity

class MainPresenterImpl(var mainView: MainContract.MainView?, private val mainInteractor: MainContract.MainInteractor) : MainContract.MainPresenter,
    MainContract.MainInteractor.OnFinishedListener {


    override fun requestDataFromServer(language: String) {

        mainView?.showProgress()
        mainInteractor.getTrendingRepositories(this,language)

    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onSuccess(trendingRepositories: ArrayList<TrendingRepositories>) {

        mainView?.hideProgress()
        mainView?.setData(trendingRepositories)

    }

    override fun onFailure() {
        mainView?.hideProgress()
    }


}