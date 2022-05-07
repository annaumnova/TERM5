package lab2

class ShapeCollector {
    private val shapeList = mutableListOf<ColoredShape2d>() //list with figures

    //add figures
    fun addFigures(figure: ColoredShape2d) = shapeList.add(figure)

    //return min square
    fun minSquareOfFigure() = shapeList.minByOrNull { it.calcArea() }

    //return max square
    fun maxSquareOfFigure() = shapeList.maxByOrNull { it.calcArea() }

    //return summarized square of figures
    fun summarizedSquare():Double = shapeList.sumOf { it.calcArea() }

//    //look for figures with color of border
//    fun searchColorBorder(figBorderColor: Color): List<ColoredShape2d> =
//        shapeList.filter { it.borderColor == figBorderColor }
//
//    //look for figures with fillcolor
//    fun searchFillColor(figFillColor: Color): List<ColoredShape2d> =
//        shapeList.filter { it.fillColor == figFillColor }

    //return the list of figures
    fun getListFigures(): List<ColoredShape2d> = shapeList.toList()

    //return the amount of figures
    fun getAmountFigures():Int = shapeList.size

    //return the group of figures by the border
    fun getGroupBorder(): Map<Color, List<ColoredShape2d>> = shapeList.groupBy { it.borderColor }

    //return the group of figures by the fillcolor
    fun getGroupFill(): Map<Color, List<ColoredShape2d>> = shapeList.groupBy { it.fillColor }

    //return this figure of this class
    fun getFigureClass(): Map<Class<Any>, List<ColoredShape2d>> = shapeList.groupBy { it.javaClass }
}