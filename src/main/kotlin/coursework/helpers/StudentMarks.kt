package coursework.helpers

@kotlinx.serialization.Serializable
//student - mark
data class StudentMarks(val student: PersonStudent, var mark: Marks) {
    override fun toString(): String {
        return "$student $mark"
    }
}