import SwiftUI
import shared

struct ContentView: View {
    @State private var shouldOpenAbout = false

    // ✅ Create the view model once
    @StateObject private var viewModel = ArticlesViewModelWrapper()

    var body: some View {
        NavigationStack {
            ArticlesScreen(viewModel: viewModel)
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutScreen()
                        }
                    }
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
