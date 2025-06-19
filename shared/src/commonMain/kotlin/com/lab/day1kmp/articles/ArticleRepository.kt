package com.lab.day1kmp.articles

class ArticleRepository (
    private  val service : ArticlesService
){
    suspend fun  getArticles() = service.fetchArticles()
}
