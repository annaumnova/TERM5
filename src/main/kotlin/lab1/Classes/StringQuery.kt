package lab1.Classes

//"query":{"searchinfo":{"totalhits":493},"search":[... }
data class StringQuery(
    val searchinfo: StringSearchInfo,
    val search: ArrayList<StringSearch>
)