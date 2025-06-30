package com.sameer.dailypulse.android.di

import com.sameer.dailypulse.article.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }
}