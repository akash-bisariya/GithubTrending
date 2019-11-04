package com.githubapplication.repositorydetail

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.githubapplication.R
import kotlinx.android.synthetic.main.activity_repository_detail.*
import kotlinx.android.synthetic.main.content_repository_detail.*

class RepositoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val upArrow =  ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow!!.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        supportActionBar!!.setHomeAsUpIndicator(upArrow);
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val repositoryUrl = intent.getStringExtra("url")

        wv_repository.loadUrl(repositoryUrl)

    }

}
