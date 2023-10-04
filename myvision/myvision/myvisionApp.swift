//
//  myvisionApp.swift
//  myvision
//
//  Created by cxq on 2023/10/4.
//

import SwiftUI

@main
struct myvisionApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }

        ImmersiveSpace(id: "ImmersiveSpace") {
            ImmersiveView()
        }
    }
}
