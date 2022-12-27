package lab2

import lab2.Readers.Reader

fun main(){

    println("\n Enter YES to process.")
    println("\n Enter NO to finish.")

    while (readln()!="NO") {

        val question = Reader()
        question.inputDataChoice()

        println("\n New openning? Enter YES or NO.")
    }
}