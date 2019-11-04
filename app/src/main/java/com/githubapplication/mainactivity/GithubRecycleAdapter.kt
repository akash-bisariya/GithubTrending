package com.githubapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.TrendingRepositories
import com.bumptech.glide.Glide
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


        holder.tvUserName.text = "@${mRepositoryList[position].username}"
        holder.tvRepoName.text = "Repository: ${mRepositoryList[position].repo.name}"
        holder.tvRepoDesc.text = "Description: ${mRepositoryList[position].repo.description}"
        holder.tvRepoUrl.text = mRepositoryList[position].repo.url
        holder.tvName.text = "Name: ${mRepositoryList.get(position).name}"



        val bitmap =  Glide.with(holder.ivRepoImage.context).load(mRepositoryList[position].avatar)
            .asBitmap()
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .into(holder.ivRepoImage)

        Log.e("visitor",""+position+" : "+mRepositoryList.get(position).repo)



    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var tvName = itemView!!.tv_name
        var ivRepoImage = itemView!!.iv_image
        var tvRepoName = itemView!!.tv_repo_name
        var tvUserName = itemView!!.tv_user_name
        var tvRepoDesc = itemView!!.tv_repo_desc
        var tvRepoUrl = itemView!!.tv_repo_url


    }


}