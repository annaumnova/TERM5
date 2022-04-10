package lab2

class Square(
    val side: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    private val siiide: Double

    //sides must be positive
    init {
        if (side <= 0)
            throw java.lang.IllegalArgumentException("It must be positive")
        else siiide = side
    }

    override fun calcArea(): Double = siiide * siiide
}
