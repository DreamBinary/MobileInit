//
//  ContentView.swift
//  myios
//
//  Created by cxq on 2023/9/30.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(spacing: 0) {
            HStack {
                Text("iOS Demo")
                    .font(.title3)
                    .fontWeight(.semibold)
                    .foregroundColor(Color.white)
                    .padding(.leading, 32)
                    .padding(.bottom)
                Spacer()
            }.background(.blue)

            MyBody()
        }
    }
}

struct MyBody: View {
    @State var cnt = 0
    var body: some View {
        ZStack {
            HStack(spacing: 0) {
                ColorBlock()
                    .frame(width: 50)
                ColorBlock()
                    .frame(width: 50)
            }
            VStack(spacing: 0) {
                ColorBlock()
                    .frame(height: 50)
                ColorBlock()
                    .frame(height: 50)
            }
            Text("\(cnt)")
                .font(.title)
                .fontWeight(.semibold)
                .foregroundColor(.white)
            HStack {
                Spacer()
                VStack {
                    Spacer()
                    Button(action: {
                        cnt += 1
                    }, label: {
                        Image(systemName: "plus")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 25, height: 25)
                            .foregroundColor(.white)
                            .padding()
                    }).background(.blue)
                        .clipShape(Circle())
                }.padding(.bottom, 32)
            }.padding(.trailing, 32)

        }.edgesIgnoringSafeArea(.all)
    }
}

struct ColorBlock: View {
    let colors = [
        Color.red, Color.green, Color.blue, Color.yellow,
        Color.orange, Color.purple, Color.pink, Color.gray, Color.black
    ]

    var body: some View {
        Rectangle()
            .fill(colors.randomElement() ?? Color.red)
            .frame(width: .infinity, height: .infinity)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
