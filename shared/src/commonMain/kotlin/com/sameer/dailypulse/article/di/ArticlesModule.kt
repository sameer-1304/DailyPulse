package com.sameer.dailypulse.article.di

import com.sameer.dailypulse.article.ArticlesViewModel
import com.sameer.dailypulse.json.ArticlesService
import com.sameer.dailypulse.json.ArticlesUseCase
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}