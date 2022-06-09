package coursework.helpers

@kotlinx.serialization.Serializable
//teacher
class Teacher(val surname: String, val name: String) {
    override fun toString() = "$surname $name"
}