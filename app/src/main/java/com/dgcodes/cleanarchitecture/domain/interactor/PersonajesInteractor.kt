package com.dgcodes.cleanarchitecture.domain.interactor

import com.dgcodes.cleanarchitecture.data.repository.PersonajesRepository
import com.dgcodes.cleanarchitecture.domain.DataDomain
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PersonajesInteractor :BaseInteractor(), KoinComponent {

    private val repository: PersonajesRepository by inject<PersonajesRepository>() //fuente de datos

    //Obtener informacion
    fun get(pagina: Int): DataDomain? = repository.getPersonajes(pagina)


    //Gestion del item favorito
    fun putFavorito(idPersonaje: Int, favorito: Boolean) = repository.putFavorito(idPersonaje, favorito)
    fun getFavorito(): Int = repository.getIdFavorito()


}