package com.dgcodes.cleanarchitecture.presentacion.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class DataUser(val info: InfoUser, val personajes: List<PersonajesUser>)
data class InfoUser(val count: Int, val next: String?, val pages: Int, val prev: String?)

@Parcelize
data class PersonajesUser(
    val created: String, val episode: List<String>, val gender: String, val id: Int, val image: String, val location: LocalizacionUser, val name: String,
    val origin: OrigenUser, val species: String, val status: String, val type: String, val url: String, var favorito: Boolean
                         ) : Parcelable

@Parcelize
data class LocalizacionUser(val name: String, val url: String) : Parcelable

@Parcelize
data class OrigenUser(val name: String, val url: String) : Parcelable


data class LocalizacionesUser(val created: String, val dimension: String, val id: Int, val name: String, val residents: List<String>, val type: String, val url: String)