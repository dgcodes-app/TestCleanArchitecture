package com.dgcodes.mvpb.domain.interactor

import com.dgcodes.mvpb.data.repository.PersonajesRepository
import com.dgcodes.mvpb.data.repository.PersonajesSource
import com.dgcodes.mvpb.domain.DataDomain
import com.dgcodes.mvpb.presentacion.model.DataUser
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