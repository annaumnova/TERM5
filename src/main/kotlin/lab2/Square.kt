package lab2

class Square(
    private val side: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {

    //sides must be positive
    init {
        if (side <= 0)
            throw java.lang.IllegalArgumentException("It must be positive")
    }

    override fun calcArea(): Double = side * side
}
