@Entry
@Component
struct LayoutChange {
  // 用于控制Column的alignItems属性
  @State itemAlign: HorizontalAlign = HorizontalAlign.Start;
  allAlign: HorizontalAlign[] = [HorizontalAlign.Start, HorizontalAlign.Center, HorizontalAlign.End];
  alignIndex: number = 0;

  build() {
    Column() {
      Column({ space: 10 }) {
        Button("1").width(100).height(50)
        Button("2").width(100).height(50)
        Button("3").width(100).height(50)
      }
      .margin(20)
      .alignItems(this.itemAlign)
      .borderWidth(2)
      .width("90%")
      .height(200)

      Button("click").onClick(() => {
        // animateTo({duration: 1000}, () => {
        //
        // })
        // 动画时长为1000ms，曲线为EaseInOut
        animateTo({ duration: 1000, curve: Curve.EaseInOut }, () => {
          this.alignIndex = (this.alignIndex + 1) % this.allAlign.length;
          // 在闭包函数中修改this.itemAlign参数，使Column容器内部孩子的布局方式变化，使用动画过渡到新位置
          this.itemAlign = this.allAlign[this.alignIndex];
        });
      })
    }
    .width("100%")
    .height("100%")
  }
}