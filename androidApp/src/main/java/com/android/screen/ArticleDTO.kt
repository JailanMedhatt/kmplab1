package com.android.screen

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDTO (
    val id : Int ,
   val title : String ,
    val body : String

)