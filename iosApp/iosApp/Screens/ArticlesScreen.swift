import SwiftUI
import shared

class ArticlesViewModelWrapper: ObservableObject {
    let articlesViewModel: ArticlesViewModel

    @Published var articlesState: ArticlesState

    private var handle: Kotlinx_coroutines_coreJob? = nil

    init() {
        articlesViewModel = ArticlesInjector().articlesViewModel
        articlesState = articlesViewModel.articlesState.value as! ArticlesState
    }

    func startObserving() {
        handle?.cancel(cause: nil)

        handle = StateFlowInterop().watchArticlesStateFlow(
            stateFlow: articlesViewModel.articlesState,
            onEach: { newState in
                DispatchQueue.main.async {
                    self.articlesState = newState
                }
            }
        )
    }

    deinit {
        handle?.cancel(cause: nil)
    }
}


struct ArticlesScreen: View {
    @ObservedObject var viewModel: ArticlesViewModelWrapper

    var body: some View {
        VStack {
            AppBar()

            if viewModel.articlesState.loading {
                Loader()
            }

//            if let error = viewModel.articlesState.error {
//                ErrorMessage(message: error)
//            }

            if !viewModel.articlesState.articles.isEmpty {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }
        .padding()
        .onAppear {
            viewModel.startObserving()
        }
    }
}
