package coursework.helpers

@kotlinx.serialization.Serializable
//student
data class PersonStudent(
    val surname: String,
    val name: String,
    val group: String
) {
    override fun toString() = "$surname $name"

}