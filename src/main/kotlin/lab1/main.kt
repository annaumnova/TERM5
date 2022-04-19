package lab1

fun main() {
    val emptyBeforeParse = "" //empty
    val theParsedEmptyList = parseBookList(emptyBeforeParse)
    println("Parsed:\n $theParsedEmptyList\n")

    val beforeParsed = "1.Ася//Тургенев И.С//1855\n" +
            "2.Накануне//Тургенев И.С//1859\n" +
            "3.Мцыри//Лермонтов М.Ю.//1840\n" +
            "4.Обрыв//Гончаров И.А.//1869"
    println("It needs to parse:\n$beforeParsed\n")

    val parsedList = parseBookList(beforeParsed)
    println("Parsed:\n $parsedList\n")

    println("The newest book:\n ${searchNewBook(parsedList)}\n")
    println("The oldest book:\n ${searchOldBook(parsedList)}\n")

    println("The book with the longest title:\n ${searchLongNamed(parsedList)}\n")
    println("The book with the shortest title:\n ${searchShortNamed(parsedList)}\n")
}