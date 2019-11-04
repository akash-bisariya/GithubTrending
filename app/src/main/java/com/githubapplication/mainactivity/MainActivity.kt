package com.githubapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.TrendingRepositories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, MainContract.MainView {

    private lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter = MainPresenterImpl(this, MainInteractorImpl(this))

        spn_language.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.language_array,
            android.R.layout.simple_spinner_dropdown_item
        )

        btn_getTrending.setOnClickListener(this)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_repositories.layoutManager = layoutManager

        rv_repositories.setHasFixedSize(true)


    }

    override fun onClick(v: View?) {
//        if (CommonUtil.hasNetwork(this)!!)
            presenter.requestDataFromServer(spn_language.selectedItem.toString())
//        else
//            Toast.makeText(this, getString(R.string.txt_no_network), Toast.LENGTH_SHORT).show()

    }


    override fun showProgress() {
        pb_progress.visibility = View.VISIBLE
        btn_getTrending.isEnabled = false
    }

    override fun hideProgress() {
        pb_progress.visibility = View.GONE
        btn_getTrending.isEnabled = true
    }

    override fun setData(trendingRepositories: ArrayList<TrendingRepositories>) {
        pb_progress.visibility = View.GONE
        rv_repositories.adapter = GithubRecycleAdapter(trendingRepositories)
        btn_getTrending.isEnabled = true

    }

    override fun onFailure() {
        pb_progress.visibility = View.VISIBLE
        btn_getTrending.isEnabled = true
    }

}
