import org.json.JSONArray
import org.json.JSONObject
import org.json.simple.parser.JSONParser
import java.net.URL

/**
 * Created by Diogo Bersuc on 26 September 2018.
 */


fun main(args: Array<String>) {

    //Define JSON URL to parse
    val enderecoJson = ""

    //Call parser and identify first Key
    val parser = JSONParser()
    var obj = parser.parse(URL(enderecoJson).readText())
    var jsonObject = JSONObject(obj as MutableMap<Any?, Any?>?)
    val placemarks = jsonObject.getJSONArray("placemarks")


    // Loop at all cars in JSON
    for (i in 0 until placemarks.length()) {
        val rec = placemarks.getJSONObject(i)
        var endereco = rec.getString("address")
        var coordinates = rec.getJSONArray("coordinates")
        var motor = rec.getString("engineType")
        var exteriorState = rec.getString("exterior")
        var fuel = rec.getInt("fuel")
        var interiorState = rec.getString("interior")
        var nome = rec.getString("name")
        var vin = rec.getString("vin")

        // Good Looking printing
        println("""
            ########################
            Car name: $nome
            Located at: $coordinates
            Type of Engine: $motor
            Fuel type: $fuel
            Exterior State: $exteriorState
            Interior State: $interiorState
            vin number: $vin
            #########################
        """.trimIndent())
    }

    println("\n${placemarks.length()} lines read")

}
/*  Ajust all code. Organize it 
    Create data class
    Class for parse JSON
    Class for Google Location
    Improve code
    Insert into Android App
*/
