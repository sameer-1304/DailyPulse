@file:JvmName("StateFlowInterop") // 👈 Required for Swift


package com.sameer.dailypulse

import com.sameer.dailypulse.article.ArticlesState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.jvm.JvmName

@OptIn(DelicateCoroutinesApi::class)
fun watchArticlesStateFlow(
    stateFlow: StateFlow<ArticlesState>,
    onEach: (ArticlesState) -> Unit
): Job {
    return GlobalScope.launch(Dispatchers.Main) {
        stateFlow.collectLatest { onEach(it) }
    }
}
