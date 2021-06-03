package com.dgcodes.cleanarchitecture.data.mapper

import com.dgcodes.cleanarchitecture.data.entities.Locations
import com.dgcodes.cleanarchitecture.domain.Localizaciones

object LocalizacionesMapper {
    fun toDomain(l: Locations?): Localizaciones? {
        if (l == null) return null
        return Localizaciones(l.created, l.dimension, l.id, l.name, l.residents, l.type, l.url)
    }

}