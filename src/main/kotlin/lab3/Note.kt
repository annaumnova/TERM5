package lab3


import java.util.*

sealed class Note(val title: String, val dateCreate: Date) {

    //TextNote
    class TextNote(title: String, private val content: String, dateCreate: Date) : Note(title, dateCreate) {
        override fun toString() = "\ntitle: $title\ncontent: $content\ndate: $dateCreate"
    }

    //Task, 'String' concatenation can be converted to a template
    class Task(title: String, dateCreate: Date, private val definition: String, private val timelim: Date) :
        Note(title, dateCreate) {
        override fun toString() =
            "\ntitle: $title\ndate: $dateCreate\ncontent: $definition\ndealine: $timelim"
    }

    //Link
    class Link(title: String, private val url: String, dateCreate: Date) : Note(title, dateCreate) {
        override fun toString() = "\ntitle: $title\ncontent: $url\ndate: $dateCreate"
    }

    //????

    //equals
    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass)
            return false

        if (this === other)
            return true

        other as Note

        if (title != other.title)
            return false

        if (dateCreate != other.dateCreate)
            return false

        return true
    }

    //hash code
    override fun hashCode(): Int {
        var answer = title.hashCode()
        answer = answer*31 + dateCreate.hashCode()
        return answer
    }
}