package com.dgcodes.cleanarchitecture.data.framework.sources

import com.dgcodes.cleanarchitecture.data.entities.Data
import com.dgcodes.cleanarchitecture.data.framework.net.Rf
import com.dgcodes.cleanarchitecture.data.repository.PersonajesSource

class PersonajesImpl : PersonajesSource {

    override fun obtenerPersonajes(pagina: Int): Data? = Rf.get().getCharacterPage(pagina).execute().body()
}
