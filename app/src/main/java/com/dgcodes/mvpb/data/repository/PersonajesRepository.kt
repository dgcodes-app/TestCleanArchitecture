package com.dgcodes.mvpb.data.repository

import com.dgcodes.mvpb.data.entities.Data
import com.dgcodes.mvpb.data.mapper.PersonajesMapper
import com.dgcodes.mvpb.domain.DataDomain
import com.dgcodes.mvpb.domain.Personajes
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PersonajesRepository : BaseRepository(), KoinComponent {


    private val sourceRetrofit: PersonajesSource by inject<PersonajesSource>()
    private val sourceSP: FavoritosSource by inject<FavoritosSource>()

    fun getPersonajes(pagina: Int): DataDomain? {
        val data: Data? = sourceRetrofit.obtenerPersonajes(pagina)
        val dd: DataDomain? = PersonajesMapper.toDomain(data)

        if (dd != null) {
            val idFavorito: Int = sourceSP.getFavorito()
            var pf: List<Personajes> = dd!!.results.filter { it.id == idFavorito }
            if (pf.size == 1) pf.first().favorito = true
        }
        return dd
    }

    fun putFavorito(idPersonaje: Int, favorito: Boolean) {
        val id = if (!favorito) -1 else idPersonaje
        sourceSP.putFavorito(id)
    }

    fun getIdFavorito(): Int = sourceSP.getFavorito()

}


interface PersonajesSource {
    fun obtenerPersonajes(pagina: Int): Data?
}

interface FavoritosSource {
    fun putFavorito(idFavorito: Int)
    fun getFavorito(): Int

}
