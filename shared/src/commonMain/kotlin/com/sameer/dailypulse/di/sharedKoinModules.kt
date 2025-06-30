package com.sameer.dailypulse.di

import com.sameer.dailypulse.article.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)