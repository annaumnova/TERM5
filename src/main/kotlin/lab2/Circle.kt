package lab2

import kotlin.math.PI

class Circle(
    private val radius: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    //radius must be positive
    init {
        if (radius <= 0)
            throw java.lang.IllegalArgumentException("It must be positive")
    }

    override fun calcArea(): Double = 2 * PI * radius
}