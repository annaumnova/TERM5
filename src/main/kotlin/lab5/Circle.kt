package lab5

import kotlin.math.PI

class Circle(
    private val radius: Double,
    override val fillColor: Colorlab5,
    override val borderColor: Colorlab5,
) : ColoredShape2d {
    //radius must be positive
    init {
        if (radius <= 0)
            throw java.lang.IllegalArgumentException("It must be positive")
    }

    override fun calcArea(): Double = 2 * PI * radius

    //to normal form
    override fun toString(): String = "Circle(radius: $radius, borderColor: $borderColor, fillColor: $fillColor)"
}