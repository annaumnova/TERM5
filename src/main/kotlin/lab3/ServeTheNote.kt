package lab3

import java.util.*

class ServeTheNote : NoteService {

    private val theNote = mutableListOf<Note>()

    //add
    fun addNotes(note: Note) = theNote.add(note)

    //all notes
    override fun getAllNotes(): List<Note> = theNote

    //all texts
    override fun getAllTextNotes(): List<Note.TextNote> = theNote.filterIsInstance<Note.TextNote>()

    //all tasks
    override fun getAllTasks(): List<Note.Task> = theNote.filterIsInstance<Note.Task>()

    //all links
    override fun getAllLinks(): List<Note.Link> = theNote.filterIsInstance<Note.Link>()

    //create texts
    override fun createTextNote(title: String, content: String, date: Date): Note.TextNote =
        Note.TextNote(title, content, date)

    //create tasks
    override fun createTasks(title: String, date: Date, definition: String, deadline: Date): Note.Task =
        Note.Task(title, date, definition, deadline)

    //create links
    override fun createLinks(title: String, date: Date, url: String): Note.Link = Note.Link(title, url, Date())

    //remove
    override fun removeNote(toDel: Note) {
        if (theNote.isNotEmpty())
            theNote.remove(toDel)
    }

    //find by name
    override fun findNoteName(title: String): List<Note> = theNote.filter { it.title == title }

    //find by type
    override fun findNoteType(typeNote: Class<Any>): List<Note> = theNote.filter { it.javaClass == typeNote }

    //sort by name
    override fun getSortedByName(): List<Note> = theNote.sortedBy { it.title }

    //sort by date
    override fun getSortedByDate(): List<Note> = theNote.sortedBy { it.dateCreate }
}