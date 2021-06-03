package com.dgcodes.cleanarchitecture.presentacion.presenter

import com.dgcodes.cleanarchitecture.domain.interactor.LocalizacionesInteractor
import com.dgcodes.cleanarchitecture.domain.interactor.PersonajesInteractor
import com.dgcodes.cleanarchitecture.presentacion.model.LocalizacionesUser
import com.dgcodes.cleanarchitecture.presentacion.model.PersonajesUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetallePresenter(private var view: IDetallePresenter): BasePresenter() {
    interface IDetallePresenter {
        fun mostrarDatosPantalla(personajesUser: PersonajesUser)
        fun mostrarDatosLocalizacion(localizacionesUser: LocalizacionesUser)
        fun mostrarError(mensaje: String)
    }

    fun obtenerInformacion(personajesUser: PersonajesUser) {
        //se obtinee la infomacion de la localizacion del usuario


        MainScope().launch {
            var localizaciones: LocalizacionesUser? = withContext(Dispatchers.IO) {
                var id = personajesUser.location.url.split("/").last()
                if (id.isNullOrBlank()) null else LocalizacionesInteractor().get(id.toInt())
            }
            view.mostrarDatosPantalla(personajesUser)
            if (localizaciones == null) localizaciones = LocalizacionesUser("", "Desconocido", 0, "", emptyList(), "", "")
            view.mostrarDatosLocalizacion(localizaciones!!)

        }
    }

    fun marcaFavorito(personajesUser: PersonajesUser, favorito: Boolean) {
        personajesUser.favorito = favorito
        PersonajesInteractor().putFavorito(personajesUser.id, personajesUser.favorito)
    }


}