package com.sameer.dailypulse.article

import com.sameer.dailypulse.BaseViewModel
import com.sameer.dailypulse.json.ArticlesService
import com.sameer.dailypulse.json.ArticlesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(
    private val useCase: ArticlesUseCase


): BaseViewModel() {

    private val _articlesState = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> = _articlesState


    init {


        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}