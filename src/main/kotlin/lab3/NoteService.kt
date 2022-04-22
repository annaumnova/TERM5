package lab3

import java.util.Date

interface NoteService {
    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>

    fun createTextNote(title: String, content: String, date: Date): Note.TextNote

    // create Task
    fun createTasks(title: String, date: Date, definition: String, deadline: Date): Note.Task

    // create Link
    fun createLinks(title: String, date: Date, url: String): Note.Link

    // removeNote
    fun removeNote(toDel: Note)

    // find by name
    fun findNoteName(title: String): List<Note>

    // find by type
    fun findNoteType(typeNote: Class<Any>): List<Note>

    // getSortedBy name
    fun getSortedByName(): List<Note>

    // getSortedBy date
    fun getSortedByDate(): List<Note>
}