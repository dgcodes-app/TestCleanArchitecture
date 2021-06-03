package com.dgcodes.mvpb.data.repository

import com.dgcodes.mvpb.data.entities.Locations
import com.dgcodes.mvpb.data.mapper.LocalizacionesMapper
import com.dgcodes.mvpb.domain.Localizaciones
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalizacionesRepository : BaseRepository(),  KoinComponent {

    val repository: LocalizacionesSource by inject<LocalizacionesSource>()

    fun getLocalizaciones(idLocalizacion: Int): Localizaciones? = LocalizacionesMapper.toDomain(repository.getLocalizacion(idLocalizacion))

}


interface LocalizacionesSource {
    fun getLocalizacion(idLocalizacion: Int): Locations?

}