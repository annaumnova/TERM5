package lab2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class ShapeCollectorTest {
    //colors
    private val amethyst = Color(153.0, 102.0, 204.0, 1.0) // amethyst
    private val arlekin = Color(68.0, 148.0, 74.0, 1.0) // arlekin

//    //figures
//    val circleFigure = Circle(2.0, amethyst, arlekin)
//    val squareFigure = Square(4.0, arlekin, amethyst)
//    val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
//    val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)


    @Test
    fun addFigures() {
        val shapeCollect = ShapeCollector()
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(squareFigure)
        assertEquals(1,shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(listOf(squareFigure),shapeCollect.getListFigures())
    }

    @Test
    fun minSquareOfFigure() {
        val shapeCollect = ShapeCollector()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val circleFigure = Circle(1.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(circleFigure)
        assertEquals(2,shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(circleFigure,shapeCollect.minSquareOfFigure())
    }

    @Test
    fun maxSquareOfFigure() {
        val shapeCollect = ShapeCollector()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val circleFigure = Circle(1.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(circleFigure)
        assertEquals(2,shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(rectangleFigure,shapeCollect.maxSquareOfFigure())
    }

    @Test
    fun summarizedSquare() {
        val shapeCollect = ShapeCollector()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(3,shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(37.0,shapeCollect.summarizedSquare())
    }

//    @Test
//    fun searchColorBorder() {
//    }
//
//    @Test
//    fun searchFillColor() {
//    }

    @Test
    fun getListofFigures() {
        val shapeCollect = ShapeCollector()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(2,shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(listOf(triangleFigure,squareFigure),shapeCollect.getListFigures())
    }

    @Test
    fun getAmountofFigures() {
        val shapeCollect = ShapeCollector()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(3,shapeCollect.getAmountFigures())
    }

    @Test
    fun getGroupBorder() {
        val shapeCollect = ShapeCollector()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(triangleFigure)
        assertEquals(3,shapeCollect.getAmountFigures())

        //border = amethyst
        assertEquals(mapOf(amethyst to listOf(rectangleFigure,squareFigure), arlekin to listOf(triangleFigure)),shapeCollect.getGroupBorder())
    }

    @Test
    fun getGroupFill() {
        val shapeCollect = ShapeCollector()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(triangleFigure)
        assertEquals(3,shapeCollect.getAmountFigures())

        //fillcolor = arlekin
        assertEquals(mapOf(arlekin to listOf(rectangleFigure,squareFigure), amethyst to listOf(triangleFigure)),shapeCollect.getGroupFill())
    }

    @Test
    fun getFigureClass() {
        val shapeCollect = ShapeCollector()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val rectangleSecond = Rectangle(3.0, 4.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(rectangleSecond)
        assertEquals(3,shapeCollect.getAmountFigures())

        //what type?
        shapeCollect.getFigureClass().forEach{ assertEquals<Class<out Any>>(it.key,it.value[0].javaClass) }
    }
}