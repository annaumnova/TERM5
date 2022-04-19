package lab1

//function, which can parse the list of string
fun parseBookList(book: String): List<Book> {
    val separatorSign1 = '.'
    val separatorSign2 = "//"
    val separatorSign3 = '\n'
    val listBooksParsed = mutableListOf<Book>() //for add + the list that will be parsed

    if (book.isNotEmpty()) { // or if(!book.isEmpty()) but it's yellow

        val strSplitBookList = book.split(separatorSign3)// splitting the book list

        for (string in strSplitBookList) { //pass the book
            var current = string // current to save for time
            current = current.substringAfter(separatorSign1)

            val title = current.substringBefore(separatorSign2) //name of books
            current = current.substringAfter(separatorSign2)

            val author = current.substringBefore(separatorSign2) //author(s) of books
            current = current.substringAfter(separatorSign2)

            val year = current //publishing year (age of book)

            listBooksParsed.add(Book(title, author, year.toInt())) //create the parsed list + year is Int
        }
    } else println("It's empty!") // the message about empty parsing without "throw "
    return listBooksParsed //the parsed list
}

fun searchNewBook(modernBook: List<Book>): Book? { // searching the newer + change the name of parameter
    return modernBook.maxByOrNull { it.year }
}

fun searchOldBook(oldBook: List<Book>): Book? { //searching the older
    return oldBook.minByOrNull { it.year }
}

fun searchLongNamed(longName: List<Book>): Book? { //searching the longest title
    return longName.maxByOrNull { it.title.length }
}

fun searchShortNamed(shortName: List<Book>): Book? { // searching the shortest title
    return shortName.minByOrNull { it.title.length }
}