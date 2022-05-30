package lab6

import lab2.*

fun main(){

    //colours
    val firstColor = Color(153.0, 102.0, 204.0, 1.0) // amethyst
    val secondColor = Color(68.0, 148.0, 74.0, 1.0) // arlekin
    val thirdColor = Color(137.0, 172.0, 118.0, 1.0) // pale green
    val fourthColor = Color(255.0, 207.0, 64.0, 1.0) // bright yellow

    //shapes or figures
    val circleFigure = Circle(1.0, firstColor, secondColor)
    val squareFigure = Square(2.0, thirdColor, secondColor)
    val rectangleFigure = Rectangle(2.0, 3.0, fourthColor, firstColor)
    val triangleFigure = Triangle(3.0, 4.0, 5.0, secondColor, thirdColor)

    //showing the class ShapeCollector
    val collectionFigures = ShapeCollector()

    //add figures
    collectionFigures.addFigures(circleFigure)
    collectionFigures.addFigures(squareFigure)
    collectionFigures.addFigures(rectangleFigure)
    collectionFigures.addFigures(triangleFigure)

    //serialazation
    //val serial = LogicSerialization()
    //create file.
    val listJson = LogicFile()
    listJson.writting(collectionFigures.getListFigures(), "C:\\Users\\Anna\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab6\\file")

    //deserialazation
    val decodedList = listJson.reading("C:\\Users\\Anna\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab6\\file").toMutableList()

    //add
    decodedList.add(squareFigure)

    //to file
    listJson.writting(collectionFigures.getListFigures(), "C:\\Users\\Anna\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab6\\file")
}