package lab5

import kotlin.math.pow

class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double,
    override val fillColor: Color,
    override val borderColor: Color,
) : ColoredShape2d {

    //sides must be positive and be checked by condition
    init {
        if ((a <= 0 || b <= 0 || c <= 0) || (a + b < c) || (a + c < b) || (b + c < a))
            throw java.lang.IllegalArgumentException("Sides must be another")
    }

    override fun calcArea(): Double =
        0.25 * kotlin.math.sqrt(4 * a * a * b * b - (a * a + b * b - c * c).pow(2.0))

    //to normal form
    override fun toString(): String = "Triangle(sides: $a, $b, $c, borderColor: $borderColor, fillColor: $fillColor)"
}

