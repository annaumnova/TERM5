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
    }
//
//    @Test
//    fun searchOldBook() {
//    }
//
//    @Test
//    fun searchLongNamed() {
//    }
//
//    @Test
//    fun searchShortNamed() {
//    }
}