package lab2

class Rectangle(
    val a: Double,
    val b: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    private val side1: Double
    private val side2: Double

    //sides must be positive
    init {
        if (a <= 0 || b <= 0)
            throw java.lang.IllegalArgumentException("Sides must be positive")
        else {
            side1 = a
            side2 = b
        }
    }

    override fun calcArea(): Double = side1 * side2
}
