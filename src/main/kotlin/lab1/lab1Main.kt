package lab1

//function, which can parse the list of string
fun parseBookList(book: String): List<BooksLib> {
    val separatorSign1 = '.'
    val separatorSign2 = "//"
    val separatorSign3 = '\n'
    var listOFallBooks = mutableListOf<BooksLib>() //for add

    if (!book.isEmpty()) {

        var stringsOFbook = book.split(separatorSign3)// splitting the book list

        for (string in stringsOFbook) { //pass the book
            var current = string // current to save for time
            current = current.substringAfter(separatorSign1)

            var title = current.substringBefore(separatorSign2) //name of books
            current = current.substringAfter(separatorSign2)

            var author = current.substringBefore(separatorSign2) //author(s) of books
            current = current.substringAfter(separatorSign2)

            var year = current //publishing year (age of book)

            listOFallBooks.add(BooksLib(title, author, year)) //create the parsed list
        }
    } else println("It's empty!") // the message about empty parsing without "throw Illegalargumentexception"
    return listOFallBooks //the parsed list
}

fun searchNewBook(newbook: List<BooksLib>): BooksLib? { // searching the newer
    return newbook.maxByOrNull { it.year }
}

fun searchOldBook(oldbook: List<BooksLib>): BooksLib? { //searching the older
    return oldbook.minByOrNull { it.year }
}

fun searchLongNamed(longName: List<BooksLib>): BooksLib? { //searching the longest title
    return longName.maxByOrNull { it.title.length }
}

fun searchShortNamed(shortName: List<BooksLib>): BooksLib? { // searching the shortest title
    return shortName.minByOrNull { it.title.length }
}

fun main() {
    val emptBFRprs = "" //empty
    val theparsedEmptyList = parseBookList(emptBFRprs)
    println("Parsed:\n $theparsedEmptyList\n")

    val beforeParsed = "1.Ася//Тургенев И.С//1855\n" +
            "2.Накануне//Тургенев И.С//1859\n" +
            "3.Мцыри//Лермонтов М.Ю.//1840\n" +
            "4.Обрыв//Гончаров И.А.//1869"
    println("It needs to parse:\n$beforeParsed\n")

    val theparsedList = parseBookList(beforeParsed)
    println("Parsed:\n $theparsedList\n")

    println("The newest book:\n ${searchNewBook(theparsedList)}\n")
    println("The oldest book:\n ${searchOldBook(theparsedList)}\n")

    println("The book with the longest title:\n ${searchLongNamed(theparsedList)}\n")
    println("The book with the shortest title:\n ${searchShortNamed(theparsedList)}\n")
}