package io.youi.example.ui

import io.youi._
import io.youi.app.screen.UIScreen
import io.youi.component.BasicText

object HelloWorld extends UIExampleScreen with UIScreen {
  override def name: String = "Hello World"
  override def path: String = "/examples/hello.html"

  override def createUI(): Unit = {
    container.children += new BasicText {
      value := "Hello, World!"
      font.size := 48.0
      fill := Color.DarkBlue
      background := Color.LightBlue
      padding.left := 20.0
      position.center := ui.position.center
      position.middle := ui.position.middle
    }
  }
}