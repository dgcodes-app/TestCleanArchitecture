package com.dgcodes.mvpb.data.mapper

import com.dgcodes.mvpb.data.entities.Locations
import com.dgcodes.mvpb.domain.Localizaciones

object LocalizacionesMapper {
    fun toDomain(l: Locations?): Localizaciones? {
        if (l == null) return null
        return Localizaciones(l.created, l.dimension, l.id, l.name, l.residents, l.type, l.url)
    }

}