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
            listOf(BooksLib("Мы", "Замятин Е.И.", "1924")),
            parseBookList(firstBook)
        )

        val secondBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            listOf(
                BooksLib("Мы", "Замятин Е.И.", "1924"),
                BooksLib("Ионыч", "Чехов А.П.", "1898")
            ),
            parseBookList(secondBook)
        )

    }

    @Test
    fun searchNewBook() {
        val NewBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            BooksLib("Мы", "Замятин Е.И.", "1924"),
            searchNewBook(parseBookList(NewBook))
        )
    }

    @Test
    fun searchOldBook() {
        val OldBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            BooksLib("Ионыч", "Чехов А.П.", "1898"),
            searchOldBook(parseBookList(OldBook))
        )
    }

    @Test
    fun searchLongNamed() {
        val LongBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            BooksLib("Ионыч", "Чехов А.П.", "1898"),
            searchLongNamed(parseBookList(LongBook))
        )
    }

    @Test
    fun searchShortNamed() {
        val ShortBook = "1.Мы//Замятин Е.И.//1924\n" +
                "2.Ионыч//Чехов А.П.//1898"
        assertEquals(
            BooksLib("Мы", "Замятин Е.И.", "1924"),
            searchShortNamed(parseBookList(ShortBook))
        )
    }
}