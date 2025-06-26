package com.sameer.dailypulse.article

data class ArcticleState (

    val loading: Boolean = false,
    val articles: List<Article> = listOf(),
    val error: String? = null

)


