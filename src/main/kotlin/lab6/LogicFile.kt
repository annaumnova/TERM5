package lab6

import lab2.ColoredShape2d
import java.io.File

class LogicFile {

    //writing the received string in JSON format to a file
    // val logic = LogicSerialization()
    fun writting(listJson: List<ColoredShape2d>, nameFilPath: String) {
        //= File(nameFilPath).writeText(LogicSerialization().serialization(listJson))
        val logic = LogicSerialization()
        File(nameFilPath).writeText(logic.serialization(listJson))
    }

    //reading such a line from a file
    fun reading(nameFilPath: String): List<ColoredShape2d> {
        // = LogicSerialization().deserialization(File(nameFilPath).readText())
        val filename = File(nameFilPath)
        val listjson = LogicSerialization()

        //not found?
        if (!filename.exists())
            throw IllegalArgumentException("Incorrect")

        return listjson.deserialization(filename.readText())
    }
}