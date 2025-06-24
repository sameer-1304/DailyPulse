//
//  AboutScreen.swift
//  iosApp
//
//  Created by SAMEER RAI on 24/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About")
            
        }
    }
}

#Preview {
    AboutScreen()
}
