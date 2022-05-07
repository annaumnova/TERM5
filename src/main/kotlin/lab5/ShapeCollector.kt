package lab5

class ShapeCollector<out T : ColoredShape2d> {

    private val shapeList = mutableListOf<T>() //list with figures

    //add all
    fun addAll(modernList: List<@UnsafeVariance T>) = modernList.forEach { shapeList.add(it) }

    //get sort
    fun getSorted(compFigures: Comparator<@UnsafeVariance T>) = shapeList.sortWith(compFigures)

    //add figures
    fun addFigures(figure: @UnsafeVariance T) = shapeList.add(figure)

    //return min square
    fun minSquareOfFigure() = shapeList.minByOrNull { it.calcArea() }

    //return max square
    fun maxSquareOfFigure() = shapeList.maxByOrNull { it.calcArea() }

    //return summarized square of figures
    fun summarizedSquare() = shapeList.sumOf { it.calcArea() }

//    //look for figures with color of border
//    fun searchColorBorder(figBorderColor: Color): List<T> = shapeList.filter { it.borderColor == figBorderColor }
//
//    //look for figures with fillcolor
//    fun searchFillColor(figFillColor: Color): List<T> = shapeList.filter { it.fillColor == figFillColor }

    //return the list of figures
    fun getListFigures(): List<T> = shapeList

    //return the amount of figures
    fun getAmountFigures() = shapeList.size

    //return the group of figures by the border
    fun getGroupBorder(): Map<Colorlab5, List<T>> = shapeList.groupBy { it.borderColor }

    //return the group of figures by the fillcolor
    fun getGroupFill(): Map<Colorlab5, List<T>> = shapeList.groupBy { it.fillColor }

    //return this figure of this class
    fun getFigureClass(): Map<Class<@UnsafeVariance T>, List<T>> = shapeList.groupBy { it.javaClass }
}