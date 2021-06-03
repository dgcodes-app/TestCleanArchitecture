package com.dgcodes.mvpb.data.entities


open  class  ErrorEntitiy(val error: String? = null )

/**
 * Clase con la informacion que se recibe
 */
data class Data(val info: Info, val results: List<Result>) : ErrorEntitiy()

/**
 * Informacion de los elemntos que recibimos en total, informando de los elemntos que tenemos, el numero total de paginas que hay
 * siguiente link,...
 */
data class Info(val count: Int, val next: String?, val pages: Int, val prev: String?)


/**
 * Elemento encontrado,. personaje que se va a mostrar en el sistema
 */
data class Result(
    val created: String, val episode: List<String>, val gender: String, val id: Int, val image: String, val location: Location, val name: String,
    val origin: Origin, val species: String, val status: String, val type: String, val url: String
                 )

data class Location(val name: String, val url: String)
data class Origin(val name: String, val url: String)


data class Locations(val created: String, val dimension: String, val id: Int, val name: String, val residents: List<String>, val type: String, val url: String)