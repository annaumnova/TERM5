package lab5

import lab2.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class ShapeCollectorTest {
    //colors
    private val amethyst = Color(153.0, 102.0, 204.0, 1.0) // amethyst
    private val arlekin = Color(68.0, 148.0, 74.0, 1.0) // arlekin


    @Test
    fun addAll() {
        val shapeColl = ShapeCollector<ColoredShape2d>()
        val circleFigure = Circle(2.0, amethyst, arlekin)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //add
        shapeColl.addAll(listOf(circleFigure, squareFigure))

        assertEquals(listOf(circleFigure, squareFigure), shapeColl.getListFigures())
    }

    @Test
    fun getSorted() {
        val shapeColl = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)

        shapeColl.addAll(listOf(rectangleFigure, triangleFigure))

        assertEquals(listOf(triangleFigure, rectangleFigure),
            shapeColl.getSorted(ShapeSortAreaComparator()))

    }

    @Test
    fun addFigures() {
        val shapeColl = ShapeCollector<ColoredShape2d>()
        val circleFigure = Circle(2.0, amethyst, arlekin)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //add
        shapeColl.addFigures(circleFigure)
        shapeColl.addFigures(squareFigure)

        //check
        assertEquals(2, shapeColl.getAmountFigures())
    }

    @Test
    fun minSquareOfFigure() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val circleFigure = Circle(1.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(circleFigure)
        assertEquals(2, shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(circleFigure, shapeCollect.minSquareOfFigure())
    }

    @Test
    fun maxSquareOfFigure() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val circleFigure = Circle(1.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(circleFigure)
        assertEquals(2, shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(rectangleFigure, shapeCollect.maxSquareOfFigure())
    }

    @Test
    fun summarizedSquare() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(3, shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(37.0, shapeCollect.summarizedSquare())
    }

    @Test
    fun getListFigures() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(2, shapeCollect.getAmountFigures())

        //what's in that?
        assertEquals(listOf(triangleFigure, squareFigure), shapeCollect.getListFigures())
    }

    @Test
    fun getAmountFigures() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)

        //size?
        shapeCollect.addFigures(triangleFigure)
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        assertEquals(3, shapeCollect.getAmountFigures())
    }

    @Test
    fun getGroupBorder() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(triangleFigure)
        assertEquals(3, shapeCollect.getAmountFigures())

        //border = amethyst
        assertEquals(mapOf(amethyst to listOf(rectangleFigure, squareFigure),
            arlekin to listOf(triangleFigure)),
            shapeCollect.getGroupBorder())
    }

    @Test
    fun getGroupFill() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val triangleFigure = Triangle(3.0, 4.0, 5.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(triangleFigure)
        assertEquals(3, shapeCollect.getAmountFigures())

        //fillcolor = arlekin
        assertEquals(mapOf(arlekin to listOf(rectangleFigure, squareFigure),
            amethyst to listOf(triangleFigure)),
            shapeCollect.getGroupFill())
    }

    @Test
    fun getFigureClass() {
        val shapeCollect = ShapeCollector<ColoredShape2d>()
        val rectangleFigure = Rectangle(5.0, 3.0, arlekin, amethyst)
        val squareFigure = Square(4.0, arlekin, amethyst)
        val rectangleSecond = Rectangle(3.0, 4.0, amethyst, arlekin)

        //size?
        shapeCollect.addFigures(rectangleFigure)
        shapeCollect.addFigures(squareFigure)
        shapeCollect.addFigures(rectangleSecond)
        assertEquals(3, shapeCollect.getAmountFigures())

        //what type?
        shapeCollect.getFigureClass().forEach {
            assertEquals<Class<out Any>>(it.key,
                it.value[0].javaClass)
        }
    }
}