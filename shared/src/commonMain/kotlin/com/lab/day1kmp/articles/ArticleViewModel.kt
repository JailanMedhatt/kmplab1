package com.lab.day1kmp.articles

import com.lab.day1kmp.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticleViewModel : BaseViewModel() {
    private var _articleStateFlow = MutableStateFlow(ArticlesState(loading = true))
    val articleStateFlow = _articleStateFlow.asStateFlow()
 val  repo : ArticleRepository
    init {
        val ktorClient = HttpClient{
            install(ContentNegotiation){
                json(Json{
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticlesService(ktorClient)
         repo = ArticleRepository(service)
        getArticles()
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(2000)

            _articleStateFlow.emit(ArticlesState(error = "Something went wrong"))

            delay(2000)

            val fetchedArticles = repo.getArticles()

            _articleStateFlow.emit(ArticlesState(articles = fetchedArticles))
        }
    }

//   private suspend fun fetchArticles(): List<Article> = mockArticles
//
//    private val mockArticles = listOf(
//        Article(
//            "Stock market today: Live updates - CNBC",
//            "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
//            "2023-11-09",
//            "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
//        ),
//        Article(
//            "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
//            "Apple's smartphones rarely go on sale, but if you’re looking to upgrade (or you're gift shopping), here are a few cost-saving options.",
//            "2023-11-09",
//            "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
//        ),
//        Article(
//            "Samsung details ‘Galaxy AI’ and a feature that can translate phone calls in real time",
//            "In a new blog post, Samsung previewed what it calls “a new era of Galaxy AI” coming to its smartphones and detailed a feature that will use artificial intelligence to translate phone calls in real time.",
//            "2023-11-09",
//            "https://cdn.vox-cdn.com/thumbor/Ocz_QcxUdtaexp1pPTMygaqzbR8=/0x0:2000x1333/1200x628/filters:focal(1000x667:1001x668)/cdn.vox-cdn.com/uploads/chorus_asset/file/24396795/DSC04128_processed.jpg",
//        ),
//    )
}