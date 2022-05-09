package lab4.controller

import lab4.model.Model
import lab4.model.State

class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.stateGame == State.MoVE) {
//            val input = readln()
//            try {
//     //           model.doMove(input)
//            } catch (e: Exception) {
//                println(e.message)
//            }
        }
    }
}