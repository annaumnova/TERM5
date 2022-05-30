package lab6

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import lab2.*
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.*

//https://gist.github.com/a-krasilnikov/859b1fac1263fc8d6d5bd2edb956833a
//classes hierarchy
private val json = Json {
    prettyPrint = true

    serializersModule = SerializersModule {
        polymorphic(ColoredShape2d::class) {
            subclass(Square::class)
            subclass(Rectangle::class)
            subclass(Triangle::class)
            subclass(Circle::class)
        }
    }
}

//serialization and deserialization
//???
class LogicSerialization {
    //serialize
    fun serialization(listJson: List<ColoredShape2d>): String = json.encodeToString(listJson)

    //deserialize
    fun deserialization(decodedList: String): List<ColoredShape2d> =
        json.decodeFromString(decodedList)
}