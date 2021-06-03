package com.dgcodes.cleanarchitecture.presentacion.mapper

import com.dgcodes.cleanarchitecture.domain.*
import com.dgcodes.cleanarchitecture.presentacion.model.*


object LocalizacionesUserMapper {
    fun toLocalizacionesUser(data: Localizaciones) :LocalizacionesUser = LocalizacionesUser(data.created, data.dimension, data.id, data.name, data.residents, data.type, data.url)
}