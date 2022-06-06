package lab2

@kotlinx.serialization.Serializable
class ShapeCollector< T : ColoredShape2d>{

    private val shapeList = mutableListOf<T>() //list with figures

    //add all
    fun addAll(modernList: List<T>) = modernList.forEach { shapeList.add(it) }

    //get sort + to list
    fun getSorted(compFigures: Comparator<T>):List<T> {
        shapeList.sortWith(compFigures)
        return shapeList.toList()
    }

    //add figures
    fun addFigures(figure:T) = shapeList.add(figure)

    //return min square
    fun minSquareOfFigure():T? = shapeList.minByOrNull { it.calcArea() }

    //return max square
    fun maxSquareOfFigure(): T? = shapeList.maxByOrNull { it.calcArea() }

    //return summarized square of figures
    fun summarizedSquare() = shapeList.sumOf { it.calcArea() }

    //look for figures with color of border
    fun searchColorBorder(figBorderColor: Color): List<T> = shapeList.filter { it.borderColor == figBorderColor }

    //look for figures with fillcolor
    fun searchFillColor(figFillColor: Color): List<T> = shapeList.filter { it.fillColor == figFillColor }

    //return the list of figures
    fun getListFigures(): List<T> = shapeList.toList()

    //return the amount of figures
    fun getAmountFigures():Int = shapeList.size

    //return the group of figures by the border
    fun getGroupBorder(): Map<Color, List<T>> = shapeList.groupBy { it.borderColor }

    //return the group of figures by the fillcolor
    fun getGroupFill(): Map<Color, List<T>> = shapeList.groupBy { it.fillColor }

    //return this figure of this class
    fun getFigureClass(): Map<Class<T>, List<T>> = shapeList.groupBy { it.javaClass }
}