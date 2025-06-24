//
//  AboutListView.swift
//  iosApp
//
//  Created by SAMEER RAI on 24/06/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import shared
import SwiftUI

struct AboutListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String
    }

    // Corrected items initialization using a closure
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()

        return [
            RowItem(title: "OS", subtitle: "\(platform.osName) \(platform.osVersion)"),
            RowItem(title: "Device", subtitle: platform.deviceModel),
            RowItem(title: "Density", subtitle: "@\(platform.density)x")
        ]
    }()

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.headline)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
}
