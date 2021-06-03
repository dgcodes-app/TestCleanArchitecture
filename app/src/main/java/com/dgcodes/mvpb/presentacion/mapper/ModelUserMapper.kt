package com.dgcodes.mvpb.presentacion.mapper

import com.dgcodes.mvpb.data.entities.Location
import com.dgcodes.mvpb.data.entities.Origin
import com.dgcodes.mvpb.data.entities.Result
import com.dgcodes.mvpb.domain.DataDomain
import com.dgcodes.mvpb.domain.Localizacion
import com.dgcodes.mvpb.domain.Origen
import com.dgcodes.mvpb.domain.Personajes
import com.dgcodes.mvpb.presentacion.model.*


object ModelUserMapper {
    fun toDataUser(data: DataDomain) :DataUser{

        return DataUser(InfoUser(data.info.count, data.info.next, data.info.pages, data.info.prev), data.results.map { migratePersonaje(it) })
    }




    private fun migratePersonaje(result: Personajes): PersonajesUser {
        return PersonajesUser(
            result.created, result.episode, result.gender, result.id, result.image, migrateLocalizacion(result.location), result.name,
            migrateOrigen(result.origin), result.species, result.status, result.type, result.url, result.favorito
                         )
    }

    private fun migrateLocalizacion(l: Localizacion) = LocalizacionUser(l.name, l.url)
    private fun migrateOrigen(o: Origen) = OrigenUser(o.name, o.url)
}