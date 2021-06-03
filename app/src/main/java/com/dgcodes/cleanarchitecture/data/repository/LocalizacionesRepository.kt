package com.dgcodes.cleanarchitecture.data.repository

import com.dgcodes.cleanarchitecture.data.entities.Locations
import com.dgcodes.cleanarchitecture.data.mapper.LocalizacionesMapper
import com.dgcodes.cleanarchitecture.domain.Localizaciones
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalizacionesRepository : BaseRepository(),  KoinComponent {

    val repository: LocalizacionesSource by inject<LocalizacionesSource>()

    fun getLocalizaciones(idLocalizacion: Int): Localizaciones? = LocalizacionesMapper.toDomain(repository.getLocalizacion(idLocalizacion))

}


interface LocalizacionesSource {
    fun getLocalizacion(idLocalizacion: Int): Locations?

}