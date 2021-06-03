package com.dgcodes.mvpb.presentacion.mapper

import com.dgcodes.mvpb.data.entities.Location
import com.dgcodes.mvpb.data.entities.Origin
import com.dgcodes.mvpb.data.entities.Result
import com.dgcodes.mvpb.domain.*
import com.dgcodes.mvpb.presentacion.model.*


object LocalizacionesUserMapper {
    fun toLocalizacionesUser(data: Localizaciones) :LocalizacionesUser = LocalizacionesUser(data.created, data.dimension, data.id, data.name, data.residents, data.type, data.url)
}