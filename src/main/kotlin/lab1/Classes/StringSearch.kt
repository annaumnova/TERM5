package lab1.Classes
//строка поиска
//..."search"= [ { "ns":...,..., "timestamp":...},... ]...
data class StringSearch(
    val ns: Int,
    val title: String,
    val pageid: Int,
    val size: Int,
    val wordcount: Int,
    val snippet: String,
    val timestamp: String
)