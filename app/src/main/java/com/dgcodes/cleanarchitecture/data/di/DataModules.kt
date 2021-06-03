package com.dgcodes.cleanarchitecture.data.di

import com.dgcodes.cleanarchitecture.data.framework.sources.FavoritosImpl
import com.dgcodes.cleanarchitecture.data.framework.sources.LocalizacionesImpl
import com.dgcodes.cleanarchitecture.data.framework.sources.PersonajesImpl
import com.dgcodes.cleanarchitecture.data.repository.*
import org.koin.dsl.module

val modulesData = module {


    single<PersonajesSource> { PersonajesImpl() }
    single<LocalizacionesSource> { LocalizacionesImpl() }
    single<FavoritosSource>{FavoritosImpl()}

    single { PersonajesRepository() }
    single { LocalizacionesRepository() }

}