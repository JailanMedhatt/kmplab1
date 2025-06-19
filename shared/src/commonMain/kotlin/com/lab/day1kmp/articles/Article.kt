package com.lab.day1kmp.articles

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String?,
    val description: String?,
    val publishedAt: String?,
    val urlToImage : String?
)
