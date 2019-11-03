package com.githubapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.TrendingRepositories
import kotlinx.android.synthetic.main.row_layout.view.*

class GithubRecycleAdapter(private val mRepositoryList: ArrayList<TrendingRepositories> ) : RecyclerView.Adapter<GithubRecycleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (mRepositoryList.size>0) mRepositoryList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("visitor",""+position+" : "+mRepositoryList.get(position).repo)
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var name = itemView!!.tv_name
        var ivRepoImage = itemView!!.iv_image
        var tvRepoName = itemView!!.tv_repo_name
        var tvUserName = itemView!!.tv_user_name


    }


}