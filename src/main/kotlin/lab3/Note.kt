package lab3


import java.util.*

sealed class Note(val title: String, val dateCreate: Date) {

    //TextNote
    class TextNote(val name: String, val content: String, val dateCreation: Date) : Note(name, dateCreation) {
        override fun toString() = "\ntitle: $name\n" + "content: $content\n" + "date: $dateCreation"
    }

    //Task
    class Task(val name: String, val dateCreation: Date, val defetion: String, val timelim: Date) :
        Note(name, dateCreation) {
        override fun toString() =
            "\ntitle: $name\n" + "date: $dateCreation\n" + "content: $defetion\n" + "dealine: $timelim"
    }

    //Link
    class Link(val name: String, val url: String, val dateCreation: Date) : Note(name, dateCreation) {
        override fun toString() = "\ntitle: $name\n" + "content: $url\n" + "date: $dateCreation"
    }
}