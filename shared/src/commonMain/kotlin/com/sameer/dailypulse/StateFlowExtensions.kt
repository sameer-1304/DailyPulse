// StateFlowInterop.swiftCompatible.kt
package com.sameer.dailypulse

import com.sameer.dailypulse.article.ArticlesState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

object StateFlowInterop {
    @OptIn(DelicateCoroutinesApi::class)
    fun watchArticlesStateFlow(
        stateFlow: StateFlow<ArticlesState>,
        onEach: (ArticlesState) -> Unit
    ): Job {
        return GlobalScope.launch(Dispatchers.Main) {
            stateFlow.collectLatest {
                onEach(it)
            }
        }
    }
}
