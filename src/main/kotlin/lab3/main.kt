@file:Suppress("DEPRECATION")

package lab3


import java.util.Date


fun main() {
    //the note
    val note = ServeTheNote()

    //create text
    val text = note.createTextNote(
        "Information",
        "Information is processed, organized and structured data. It enables decision making processes.",
        Date(2022, 5, 22)
    )
    note.addNotes(text)

    //create task
    val task = note.createTasks(
        "TO DO LIST",
        Date(), "lab oop\n" + "aisd 1 lab\n" + "compmath", Date(2022, 4, 22)

    )
    note.addNotes(task)

    //create link
    val link = note.createLinks(
        "the cat.png",
        Date(), "https://yandex.ru/images/search?text=cat%20png&itype=png&from=tabbar"
    )
    note.addNotes(link)

    //print all of notes
    println("\nThe all notes: ${note.getAllNotes()}")
    println("\nThe all texts: ${note.getAllTextNotes()}")
    println("\nThe all tasks: ${note.getAllTasks()}")
    println("\nThe all links: ${note.getAllLinks()}")

    //find by name and type
    println("\nFind by name: ${note.findNoteName("TO DO LIST")}")
    println("\nFind by type: ${note.findNoteType(note.javaClass)}")

    //sort by name and date
    println("\nSort by name: ${note.getSortedByName()}")
    println("\nSort by date: ${note.getSortedByDate()}")

    //remove and then print-check
    note.removeNote(text)
    println("\nAfter removing: ${note.getAllNotes()}")
}