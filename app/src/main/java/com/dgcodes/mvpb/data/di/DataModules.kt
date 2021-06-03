package com.dgcodes.mvpb.data.di

import com.dgcodes.mvpb.data.framework.sources.FavoritosImpl
import com.dgcodes.mvpb.data.framework.sources.LocalizacionesImpl
import com.dgcodes.mvpb.data.framework.sources.PersonajesImpl
import com.dgcodes.mvpb.data.repository.*
import org.koin.dsl.module

val modulesData = module {


    single<PersonajesSource> { PersonajesImpl() }
    single<LocalizacionesSource> { LocalizacionesImpl() }
    single<FavoritosSource>{FavoritosImpl()}

    single { PersonajesRepository() }
    single { LocalizacionesRepository() }

}