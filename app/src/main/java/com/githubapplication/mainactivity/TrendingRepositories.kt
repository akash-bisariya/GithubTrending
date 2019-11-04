package com.githubapplication.mainactivity

data class TrendingRepositories(
    val username: String,
    val name: String,
    val type: String,
    val url: String,
    val avatar: String,
    val repo: Repo
) {
    data class Repo(
        val name: String,
        val description: String,
        val url: String
    )
}