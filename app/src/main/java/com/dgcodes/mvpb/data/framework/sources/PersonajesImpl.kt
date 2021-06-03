package com.dgcodes.mvpb.data.framework.sources

import com.dgcodes.mvpb.data.entities.Data
import com.dgcodes.mvpb.data.framework.net.Rf
import com.dgcodes.mvpb.data.repository.PersonajesSource

class PersonajesImpl : PersonajesSource {

    override fun obtenerPersonajes(pagina: Int): Data? = Rf.get().getCharacterPage(pagina).execute().body()
}
