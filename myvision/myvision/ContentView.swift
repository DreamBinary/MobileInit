//
//  ContentView.swift
//  myvision
//
//  Created by cxq on 2023/10/4.
//

import SwiftUI
import RealityKit
import RealityKitContent

struct ContentView: View {
    @State private var cnt = 0
    var body: some View {
        VStack {
            Model3D(named: "Scene", bundle: realityKitContentBundle)
                .padding(.bottom, 50)

            Text("\(cnt)")
                .font(.title)
                .fontWeight(.semibold)
            
            HStack {
                Button(action: {
                    cnt += 1
                }, label: {
                    Image(systemName: "plus")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 25, height: 25)
                        .foregroundColor(.white)
                        .padding()
                }).clipShape(Circle())
                
                Button(action: {
                    cnt -= 1
                }, label: {
                    Image(systemName: "minus")
                        .resizable()
                        .scaledToFit()
                        .frame(width: 25, height: 25)
                        .foregroundColor(.white)
                        .padding()
                }).clipShape(Circle())
            }
        }
        .padding()
    }
}

#Preview(windowStyle: .automatic) {
    ContentView()
}
