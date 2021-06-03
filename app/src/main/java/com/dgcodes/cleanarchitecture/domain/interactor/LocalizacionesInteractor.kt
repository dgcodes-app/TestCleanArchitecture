package com.dgcodes.cleanarchitecture.domain.interactor

import com.dgcodes.cleanarchitecture.data.repository.LocalizacionesRepository
import com.dgcodes.cleanarchitecture.domain.Localizaciones
import com.dgcodes.cleanarchitecture.presentacion.mapper.LocalizacionesUserMapper
import com.dgcodes.cleanarchitecture.presentacion.model.LocalizacionesUser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalizacionesInteractor : BaseInteractor(), KoinComponent {


    private val repository: LocalizacionesRepository by inject<LocalizacionesRepository>()

    fun get(idLocalizacion: Int): LocalizacionesUser? {
        val l: Localizaciones? = repository.getLocalizaciones(idLocalizacion)
        if (l == null) return null
        return LocalizacionesUserMapper.toLocalizacionesUser(l)
    }
}