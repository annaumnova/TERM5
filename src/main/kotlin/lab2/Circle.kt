package lab2

import kotlin.math.PI

@kotlinx.serialization.Serializable
class Circle(
    private val radius: Double,
    override val fillColor: Color,
    override val borderColor: Color,
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