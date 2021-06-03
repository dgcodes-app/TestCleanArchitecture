package com.dgcodes.cleanarchitecture.presentacion.navigation

import com.dgcodes.cleanarchitecture.Init
import com.dgcodes.cleanarchitecture.presentacion.model.PersonajesUser
import com.dgcodes.cleanarchitecture.presentacion.view.acitivities.DetalleActivity
import com.dgcodes.cleanarchitecture.presentacion.view.acitivities.ListaActivity

object Navigation {
    val TAG_PERSONAJE = "PERSONAJE"

    fun toLista() = Init.applicationContext().startActivity(ListaActivity.getIntentActivity())
    fun toDetalle(personajesUser: PersonajesUser) = Init.applicationContext().startActivity(DetalleActivity.getIntentActivity(personajesUser))


}