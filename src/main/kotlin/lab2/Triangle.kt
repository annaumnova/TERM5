package lab2

import java.lang.Math.sqrt
import kotlin.math.pow

class Triangle(
    val a: Double,
    val b: Double,
    val c: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    private val side1: Double
    private val side2: Double
    private val side3: Double

    //sides must be positive and be checked by condition
    init {
        if ((a <= 0 || b <= 0 || c <= 0) || (a + b < c) || (a + c < b) || (b + c < a))
            throw java.lang.IllegalArgumentException("Sides must be another")
        else {
            side1 = a
            side2 = b
            side3 = c
        }
    }

    override fun calcArea(): Double =
        0.25 * sqrt(4 * side1 * side1 * side2 * side2 - (side1 * side1 + side2 * side2 - side3 * side3).pow(2.0))
}

