package lab5

class ShapeSortAreaComparator : Comparator<ColoredShape2d> {

    override fun compare(first: ColoredShape2d, second: ColoredShape2d): Int {
        if (first.calcArea() == second.calcArea()) {
            return 0 //ok
        } else if (first.calcArea() < second.calcArea()) {
            return 1
        }
        else return -1
    }
}