package com.dgcodes.mvpb.data.mapper

import com.dgcodes.mvpb.data.entities.Data
import com.dgcodes.mvpb.data.entities.Location
import com.dgcodes.mvpb.data.entities.Origin
import com.dgcodes.mvpb.data.entities.Result
import com.dgcodes.mvpb.domain.*

object PersonajesMapper {

    fun toDomain(data: Data?): DataDomain?  {
        if (data == null) return  null
        return DataDomain(InfoDomain(data.info.count, data.info.next, data.info.pages, data.info.prev), data.results.map { migratePersonaje(it) })
    }




    private fun migratePersonaje(result: Result): Personajes {
        return Personajes(
            result.created, result.episode, result.gender, result.id, result.image, migrateLocalizacion(result.location), result.name,
            migrateOrigen(result.origin), result.species, result.status, result.type, result.url
                         )
    }

    private fun migrateLocalizacion(l: Location) = Localizacion(l.name, l.url)
    private fun migrateOrigen(o: Origin) = Origen(o.name, o.url)


}