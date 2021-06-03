package com.dgcodes.mvpb.domain.interactor

import com.dgcodes.base.utils.log.MyLog
import com.dgcodes.mvpb.data.mapper.LocalizacionesMapper
import com.dgcodes.mvpb.data.repository.LocalizacionesRepository
import com.dgcodes.mvpb.data.repository.PersonajesRepository
import com.dgcodes.mvpb.domain.Localizaciones
import com.dgcodes.mvpb.presentacion.mapper.LocalizacionesUserMapper
import com.dgcodes.mvpb.presentacion.model.LocalizacionesUser
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