package com.dgcodes.cleanarchitecture.domain



data class DataDomain(val info: InfoDomain, val results: List<Personajes>)
data class InfoDomain(val count: Int, val next: String?, val pages: Int, val prev: String?)

data class Personajes(
    val created: String, val episode: List<String>, val gender: String, val id: Int, val image: String, val location: Localizacion, val name: String,
    val origin: Origen, val species: String, val status: String, val type: String, val url: String, var favorito: Boolean = false
                 )

data class Localizacion(val name: String, val url: String)
data class Origen(val name: String, val url: String)

data class Localizaciones(val created: String, val dimension: String, val id: Int, val name: String, val residents: List<String>, val type: String, val url: String)