package com.tora.khabartimes.data.model

data class ArticleModel(
    val id: Long = 0L,
    val mediaUrl: String = "",
    val publishedDate: String = "",
    val title: String = "",
    val byline: String = ""
)

fun PopularArticles.toArticleModelList(): List<ArticleModel> =
    this.results?.takeIf { it.isNotEmpty() }?.map { article ->
        ArticleModel(
            id = article.id!!,
            mediaUrl = article.media.takeIf { it!!.isNotEmpty() }
                ?.get(0)?.mediaMetadata.takeIf { it!!.isNotEmpty() }?.get(0)?.url.orEmpty(),
            publishedDate = article.publishedDate.orEmpty(),
            title = article.title.orEmpty(),
            byline = article.byline.orEmpty()
        )
    } ?: emptyList()
