package lab2.Readers

import lab2.Items.Items
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.w3c.dom.NamedNodeMap
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import javax.xml.parsers.DocumentBuilderFactory


//consts
val firstfloor: Int = 1
val lastfloor: Int = 5

class Reader {

    private var itemRepetition: HashMap<Items, Int> = hashMapOf() //items and their repetitions
    private val cities: MutableList<String> = mutableListOf() //cities in address of saved files (.csv, .xml)

    //to input data or stop programm
    // user must make choice
    fun inputDataChoice() {
        println("\nEnter name of files to process.")
        println("Enter NO to finish.")

        var flag = true
        val something = readln()

        while (flag != false && something != "NO") {

            if (File(something).exists()) {

                if (something.lowercase().endsWith("csv")) {
                    println("\nCSV-file is processed\n")
                    readCSV(something)
                    flag = false
                } else if (something.lowercase().endsWith("xml")) {
                    println("\nXML-file is processed\n")
                    readXML(something)
                    flag = false
                }
            } else {
                println("\nIt doesn't exist!\n")
                flag = false
            }
            println("\nPlease, enter something to continue  processing files\n\t or enter F to finish.")
        }
    }


    //to read csv-file and then to make summary statistics
    private fun readCSV(csvPath: String) {
        val startTime: Long = System.currentTimeMillis() //start time, when reading begins
        val csvReader = FileReader(csvPath) //reader for csv-file
        val buffFileReader = BufferedReader(csvReader)

        //parser for reading
        val csvParser = CSVParser(
            buffFileReader, CSVFormat.DEFAULT
                .withDelimiter(';')
                .withQuote('"')
                .withRecordSeparator("\r\n")
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
        )

        for (csvRecord in csvParser) {
            val newItems = Items(
                csvRecord.get("city"),
                csvRecord.get("street"),
                csvRecord.get("house").toInt(),
                csvRecord.get("floor").toInt()
            )
            if (!cities.contains(newItems.city)) {
                cities.add(newItems.city)
            }

            if (itemRepetition.isNotEmpty() && itemRepetition.containsKey(newItems)) {
                itemRepetition[newItems] = itemRepetition[newItems]!!.plus(1)
            } else {
                itemRepetition[newItems] = 1
            }
        }

        outputSummaryStatistics(itemRepetition, cities, startTime)
    }

    //to output summary statistics:
    // 1. duplicate entries with repetition count (first for-loop)
    // 2. how many in each city: 1, 2, 3, 4 and 5 storey houses (second for-loops)
    // 3. file processing time
    private fun outputSummaryStatistics(
        itemRepetition: HashMap<Items, Int>,
        cities: MutableList<String>,
        startTime: Long,
    ) {
        cities.sort() //for right order

        println("Duplicates with repetitions:\n")
        itemRepetition.filterValues { it > 1 }
            .forEach { println("Items: ${it.key.city}, ${it.key.street}, ${it.key.house}, ${it.key.floor}; Repetition: ${it.value}  ") }

        println("\nCities with storey houses:\n")
        for (eachCity in cities) {
            val count = itemRepetition.filterKeys { eachCity == it.city }
            for (i in firstfloor..lastfloor) {
                println("$eachCity city, ${count.filterKeys { i == it.floor }.count()} houses, ${i} floors")
            }
        }

        val runTime = System.currentTimeMillis() - startTime
        println("\nRuntime: ${runTime} ms\n")
    }

    //to read xml-file and then to make summary statistics
    private fun readXML(xmlPath: String) {

        val startTime: Long = System.currentTimeMillis() //start time, when reading begins

        val builderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = builderFactory.newDocumentBuilder()
        val doc = docBuilder.parse(File(xmlPath))
        val nList = doc.documentElement.getElementsByTagName("item")

        for (i in 0 until nList.getLength()) {
            val attributes: NamedNodeMap = nList.item(i).attributes
            val newItems = Items(
                attributes.getNamedItem("city").nodeValue,
                attributes.getNamedItem("street").nodeValue,
                attributes.getNamedItem("house").nodeValue.toInt(),
                attributes.getNamedItem("floor").nodeValue.toInt()
            )

            if (!cities.contains(newItems.city)) {
                cities.add(newItems.city)
            }

            if (itemRepetition.isNotEmpty() && itemRepetition.containsKey(newItems)) {
                itemRepetition[newItems] = itemRepetition[newItems]!!.plus(1)
            } else {
                itemRepetition[newItems] = 1
            }
        }

        outputSummaryStatistics(itemRepetition, cities, startTime)
    }


}