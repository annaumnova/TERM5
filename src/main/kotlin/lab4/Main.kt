package lab4

//import lab4.controller.Controller
import lab4.model.Model
import lab4.view.ConsoleUi

fun main() {
    val model = Model()
   // ConsoleUi(model)
   //Controller(model)
println(model)

    println(model.doMove("A"))
}