package lab1

import java.awt.Desktop
import java.net.URI
import java.net.URL
import com.google.gson.Gson
import lab1.Classes.StringRequest
import lab1.Classes.StringSearch
import java.net.HttpURLConnection
import java.net.URLEncoder.*


//1.Считать введенные пользователем данные
//2.Сделать запрос к серверу
//3.Распарсить ответ
//4.Вывести результат поиска
//5.Открыть нужную страницу в браузере

// const
const val link = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
const val linkRes = "https://ru.wikipedia.org/w/index.php?curid="

class SearchRequest {

    private var result: List<StringSearch> = listOf()

    private fun readQuest() {

        println("Input your quest:")
        val quest = encode(readln(), "UTF-8")

        val linkQuestConnect =
            URL(link + quest).openConnection() as HttpURLConnection
        val inform = linkQuestConnect.inputStream.bufferedReader().readText()

        result = Gson().fromJson(inform, StringRequest::class.java).query.search
    }

    private fun listOfRequests() {
        println("\nRequests can be found:")
        for (counter in result.indices)
            println("${counter + 1}:${result[counter].title}")
    }

    private fun outputResult() {

        println("\nEnter something to continue searching.")
        println("Enter F to finish.")

        while (readln() != "F") {

            listOfRequests()

            println("\nCounter of request:")
            val counter = readln()

            //to check the counter
            try {
                if (counter.toInt() <= 0 || counter.toInt() > result.size) {
                    println("It doesn't exist. Please, select the counter from list of requests.")
                    // listOfRequests()
                } else
                    Desktop.getDesktop()
                        .browse(URI(linkRes + result[counter.toInt() - 1].pageid))

            } catch (e: NumberFormatException) {
                println("It should be another\n\tbecause it is $e")
            }

            println("\nPlease, enter something to continue searching\n\t or enter F to finish.")
        }
    }

    //searching the information from Wikipedia
    fun searchingWiki() {
        readQuest()
        outputResult()
    }
}