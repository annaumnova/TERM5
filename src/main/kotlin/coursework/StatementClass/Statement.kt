package coursework.StatementClass

import coursework.helpers.Marks
import coursework.helpers.StudentMarks
import coursework.helpers.Teacher

@kotlinx.serialization.Serializable
class Statement(
    val teacher: Teacher,
    val subject: String,
    val group: String,
    private var studentMarksList: MutableList<StudentMarks>,
) {

    constructor(teacher: Teacher, subject: String, studentMarkList: MutableList<StudentMarks>) : this(teacher, subject,
        studentMarkList[0].student.group,
        studentMarkList)

    init {
        if (studentMarksList.isEmpty())
            throw IllegalArgumentException("Group shouldn't be empty")

        studentMarksList.forEach {
            if (it.student.group != group)
                throw IllegalArgumentException("Students in statement should be in the one group")
        }

        studentMarksList = studentMarksList.toMutableList()  //for encapsulation
    }

    //to normal form
    override fun toString(): String {
        var studentMarksListToTable: String = ""
        studentMarksList.forEach {
            studentMarksListToTable += "\n$it"
        }
        return "Statement\n" +
                "teacher: $teacher\n" +
                "subject: $subject\n" +
                "group: $group\n" +
                studentMarksListToTable
    }

    //find students
    fun findStudents(substr: String) {
        val filteredStudentMarksList =
            studentMarksList.filter { it.student.name.contains(substr) || it.student.surname.contains(substr) }

        if (filteredStudentMarksList.isEmpty())
            println("Students didn't found")
        else {
            println("Found students:")
            filteredStudentMarksList.forEach {
                println(it)
            }
        }
    }

    //set marks for all students
    fun setMarks() {
        println("Get marks of A, B, C, D, F, NA or enter for pass")
        studentMarksList.forEach {
            print("${it.student} from ${it.mark} to ")
            val mark = readln()
            when (mark) {
                "A" -> it.mark = Marks.A
                "B" -> it.mark = Marks.B
                "C" -> it.mark = Marks.C
                "D" -> it.mark = Marks.D
                "F" -> it.mark = Marks.F
                "NA" -> it.mark = Marks.NA
                "" -> {}
                else -> println("Can't put mark $mark")
            }
        }
    }

    //set marks for not certified (Н/А) students
    fun setNAMarks() {
        val filteredStudentMarksList =
            studentMarksList.filter { it.mark == Marks.NA }

        if (filteredStudentMarksList.isEmpty())
            println("Students didn't found")
        else {
            println("Found students:")
            filteredStudentMarksList.forEach {
                println(it)
            }
            println("Get marks of A, B, C, D, F, NA or enter for pass")
            studentMarksList.forEach {
                if (it.mark == Marks.NA) {
                    print("${it.student} from ${it.mark} to ")
                    val mark = readln()
                    when (mark) {
                        "A" -> it.mark = Marks.A
                        "B" -> it.mark = Marks.B
                        "C" -> it.mark = Marks.C
                        "D" -> it.mark = Marks.D
                        "F" -> it.mark = Marks.F
                        "NA" -> it.mark = Marks.NA
                        "" -> {}
                        else -> println("Can't put mark $mark")
                    }

                }
            }
        }
    }

    //set marks for chosen students in list
    fun setMarks(substr: String) {
        //filter the list
        val filteredStudentMarksList =
            studentMarksList.filter { it.student.name.contains(substr) || it.student.surname.contains(substr) }

        if (filteredStudentMarksList.isEmpty())
            println("Students didn't found")
        else {
            println("Found students:")
            filteredStudentMarksList.forEach {
                println(it)
            }
            println("Get marks of A, B, C, D, F, NA or enter for pass")
            studentMarksList.forEach {
                if (it.student.name.contains(substr) || it.student.surname.contains(substr)) {
                    print("${it.student} from ${it.mark} to ")
                    val mark = readln()
                    when (mark) {
                        "A" -> it.mark = Marks.A
                        "B" -> it.mark = Marks.B
                        "C" -> it.mark = Marks.C
                        "D" -> it.mark = Marks.D
                        "F" -> it.mark = Marks.F
                        "NA" -> it.mark = Marks.NA
                        "" -> {}
                        else -> println("Impossible to put the mark $mark")
                    }

                }
            }
        }
    }
}