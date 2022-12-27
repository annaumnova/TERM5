package lab1

fun main() {
    var flag = true
    while (flag) {
        val question = SearchRequest()
        question.searchingWiki()

        println("New quest? Enter YES or NO.")
        if (readln() == "NO")
            flag = false
    }
}