package lab2

import kotlin.math.PI

class Circle(
    val radius: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    private val radioos: Double

    //radius must be positive
    init {
        if (radius <= 0)
            throw java.lang.IllegalArgumentException("It must be positive")
        else radioos = radius
    }

    override fun calcArea(): Double = 2 * PI * radioos
}