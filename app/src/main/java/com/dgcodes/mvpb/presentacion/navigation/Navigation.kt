package com.dgcodes.mvpb.presentacion.navigation

import android.content.Intent
import com.dgcodes.mvpb.Init
import com.dgcodes.mvpb.presentacion.model.PersonajesUser
import com.dgcodes.mvpb.presentacion.view.acitivities.DetalleActivity
import com.dgcodes.mvpb.presentacion.view.acitivities.ListaActivity

object Navigation {
    val TAG_PERSONAJE = "PERSONAJE"

    fun toLista() = Init.applicationContext().startActivity(ListaActivity.getIntentActivity())
    fun toDetalle(personajesUser: PersonajesUser) = Init.applicationContext().startActivity(DetalleActivity.getIntentActivity(personajesUser))


}