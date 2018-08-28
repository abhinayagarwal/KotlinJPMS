package xyz.abhinay

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class Main : Application() {
    override fun start(primaryStage: Stage) {
        val stackPane = StackPane(Label("JavaFX in Kotlin with JPMS"))
        val scene = Scene(stackPane, 300.0, 300.0)
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(Main::class.java)
}