package lab1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Lab1MainKtTest {
    //    private val bookOne = BooksLib("Мы","Замятин Е.И.","1924")
    //    private val bookTwo = BooksLib("Ионыч","Чехов А.П.","1898")

    @Test
    fun parseBookList() {
        val firstBook = "1.Мы//Замятин Е.И.//1924"
        assertEquals(
            listOf(Book("Мы", "Замятин Е.И.", 1924)),
            parseBookList(firstBook)
        )

        val secondBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            listOf(
                Book("Мы", "Замятин Е.И.", 1924),
                Book("Ионыч", "Чехов А.П.", 1898)
            ),
            parseBookList(secondBook)
        )

    }

    @Test
    fun searchNewBook() {
        val modernBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            Book("Мы", "Замятин Е.И.", 1924),
            searchNewBook(parseBookList(modernBook))
        )
    }

    @Test
    fun searchOldBook() {
        val oldBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            Book("Ионыч", "Чехов А.П.", 1898),
            searchOldBook(parseBookList(oldBook))
        )
    }

    @Test
    fun searchLongNamed() {
        val longBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            Book("Ионыч", "Чехов А.П.", 1898),
            searchLongNamed(parseBookList(longBook))
        )
    }

    @Test
    fun searchShortNamed() {
        val shortBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            Book("Мы", "Замятин Е.И.", 1924),
            searchShortNamed(parseBookList(shortBook))
        )
    }
}