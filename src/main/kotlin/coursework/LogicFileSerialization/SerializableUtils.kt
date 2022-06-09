package coursework.LogicFileSerialization

import coursework.StatementClass.Statement
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object SerializableUtils {
    public val json = Json

    fun serialization(statement: Statement) =
        json.encodeToString(statement)

    fun deserialization(statement: String) =
        json.decodeFromString<Statement>(statement)

    fun serializationToFile(statement: Statement, fileName: String) {
        File(fileName).writeText(serialization(statement))
    }

    fun deserializationFromFile(fileName: String): Statement {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return deserialization(file.readText())
    }
}