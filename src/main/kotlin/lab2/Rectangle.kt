package lab2

@kotlinx.serialization.Serializable
class Rectangle(
    private val a: Double,
    private val b: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {

    //sides must be positive
    init {
        if (a <= 0 || b <= 0)
            throw java.lang.IllegalArgumentException("Sides must be positive")
    }

    override fun calcArea(): Double = a * b

    //to normal form
    override fun toString(): String = "Rectangle(sides: $a, $b, borderColor: $borderColor, fillColor: $fillColor)"
}
