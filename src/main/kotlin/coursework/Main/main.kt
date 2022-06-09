package coursework

import coursework.LogicFileSerialization.SerializableUtils
import coursework.StatementClass.Statement
import coursework.helpers.Marks
import coursework.helpers.PersonStudent
import coursework.helpers.StudentMarks
import coursework.helpers.Teacher

//enter
fun main() {

    println("Enter teacher's in format:\n surname\n name")
    val teacher = Teacher(readln(), readln())

    println("Enter the subject")
    val subject = readln()

    println("Enter the group")
    val group = readln()

    println("Enter the number of student")
    val numberOfStudents = readln().toInt()

    println("Enter the group in format:\n surname\n name")
    val studentsList: MutableList<StudentMarks> = emptyList<StudentMarks>().toMutableList()

    for (i in 1..numberOfStudents) {
        studentsList.add(StudentMarks(PersonStudent(readln(), readln(), group), Marks.NA))
        println()
    }

    val statement = Statement(teacher, subject, group, studentsList)
    var flag = ""
    while (flag != "E") {
        println("Enter action:\nMA - mark all, \nMNA - mark NA, \nMCS - mark chosen student," +
                "\nE - exit, \nS - serialize statement to file, \nD - serialize statement from file")
        when (readln()) {
            "MA" -> statement.setMarks() //вызов всей ведосмоти для изменения
            "MNA" -> statement.setNAMarks() // вызов ведомости для изменения оценки неаттестованных
            "MCS" -> {
                println("Enter string for find the student " +
                        "\nYou may enter surname/name")
                val choice: String = readln()
                statement.setMarks(choice) // вызов ведомости для студентов с подстрокой для изменения}
            }
            //сериализация ведомости в файл StatementFile (перезапись)
            "S" -> SerializableUtils.serializationToFile(statement, "StatementFile")
            //пример десериализации ведомости из файла StatementFile
            "D" -> SerializableUtils.deserializationFromFile("StatementFile")
            "E" -> {
                flag = "E"
            }

            else -> println("Impossible action!")
        }
    }

    println(statement)
}