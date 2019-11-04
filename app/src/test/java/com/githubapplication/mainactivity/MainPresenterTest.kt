package com.githubapplication.mainactivity

import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {
    lateinit var mainPresenterImpl:MainContract.MainPresenter

    @Mock
    lateinit var mainActivityView: MainContract.MainView

    @Mock
    lateinit var mainActivityInteractor: MainContract.MainInteractor

    @Mock
    lateinit var onFinishedListener: MainContract.MainInteractor.OnFinishedListener


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        mainPresenterImpl = MainPresenterImpl(mainActivityView, mainActivityInteractor)
    }


    @Test
    fun testAttach() {
        Assert.assertNotNull((mainPresenterImpl as MainPresenterImpl).mainView)
    }

    @Test
    fun testShowLoading(){
        mainPresenterImpl.requestDataFromServer("java")
        verify(mainActivityView).showProgress()
    }

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T

    @Test
    fun testFetchGithubData(){
        mainPresenterImpl.requestDataFromServer("java");
        verify(mainActivityInteractor, atLeastOnce()).getTrendingRepositories(any(),
            ArgumentMatchers.anyString())
    }

}