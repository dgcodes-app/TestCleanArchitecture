package com.dgcodes.mvpb.data.framework.sources

import com.dgcodes.mvpb.data.framework.net.Rf
import com.dgcodes.mvpb.data.repository.LocalizacionesSource

class LocalizacionesImpl : LocalizacionesSource {

    override fun getLocalizacion(idLocalizacion: Int) = Rf.get().getLocation(idLocalizacion).execute().body()
}