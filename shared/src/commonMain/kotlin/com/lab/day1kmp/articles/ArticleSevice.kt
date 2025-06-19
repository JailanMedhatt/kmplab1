package com.lab.day1kmp.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "8f0706b712404d49938f4771203efa6f"
    suspend fun fetchArticles(): List<Article> {
        val response: ArticleResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles ?: emptyList()
    }
}