package com.githubapplication.mainactivity


import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.githubapplication.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class RepositoryDetailActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testClickOnGetTrendingRepositories() {
        val appCompatButton = onView(
            allOf(
                withId(com.githubapplication.R.id.btn_getTrending), withText("Get Trending Repositories"), isDisplayed()
            )
        )

        appCompatButton.perform(click())

        testIfProgressDialogDisplayed()

        testIfRepositoryListExistAndPerformClick()
    }


    private fun testIfProgressDialogDisplayed() {
        val viewGroup = onView(
            allOf(
                withId(R.id.pb_progress), isDisplayed()
            )
        )
    }


    fun testIfRepositoryListExistAndPerformClick() {

        val countingIdlingResource = mActivityTestRule.activity.getEspressoIdlingResourceGetRepository()

        IdlingRegistry.getInstance().register(countingIdlingResource)

        val viewGroup = onView(
            allOf(
                withId(R.id.rv_repositories), isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))

        IdlingRegistry.getInstance().unregister(countingIdlingResource)

        val constraintLayout =
                onView(allOf(withIndex(withId(R.id.row_repository),0),
                    isDisplayed()))


        constraintLayout.perform(click())

//        testIfRepositoryDetailActivityExist()
    }

//    fun testIfRepositoryDetailActivityExist(){
//
//    val webView = onView(
//            allOf(
//                withId(R.id.wv_repository), isDisplayed()
//            )
//        )
//        webView.check(matches(isDisplayed()))
//    }

    fun withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            internal var currentIndex = 0

            override fun describeTo(description: Description) {
                description.appendText("with index: ")
                description.appendValue(index)
                matcher.describeTo(description)
            }

            override fun matchesSafely(view: View): Boolean {
                return matcher.matches(view) && currentIndex++ == index
            }
        }
    }
}
