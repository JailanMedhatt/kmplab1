package com.lab.day1kmp.articles

import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse (
    val status : String?,
    val totalResults : Int?,
    val articles : List <Article>

)


