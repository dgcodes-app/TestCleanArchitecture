package com.dgcodes.cleanarchitecture.data.framework.sources

import com.dgcodes.cleanarchitecture.data.framework.net.Rf
import com.dgcodes.cleanarchitecture.data.repository.LocalizacionesSource

class LocalizacionesImpl : LocalizacionesSource {

    override fun getLocalizacion(idLocalizacion: Int) = Rf.get().getLocation(idLocalizacion).execute().body()
}