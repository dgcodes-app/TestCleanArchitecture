package com.dgcodes.mvpb.presentacion.presenter

import com.dgcodes.mvpb.domain.DataDomain
import com.dgcodes.mvpb.domain.interactor.PersonajesInteractor
import com.dgcodes.mvpb.presentacion.mapper.ModelUserMapper
import com.dgcodes.mvpb.presentacion.model.PersonajesUser
import com.dgcodes.mvpb.presentacion.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Controla la interfgace 
 */
class ListaPresenter(var view: IViewPresenter): BasePresenter() {

    var paginaPresentar: Int = 1
    var hayPaginaSiguiente: Boolean = true
    val personajesInteractor: PersonajesInteractor = PersonajesInteractor()

    //interface para controlar la vista.
    interface IViewPresenter {
        fun cargarDatos(informacion: List<PersonajesUser>)
        fun refreshAdapter()
        fun mostrarTotalElementos(numeroElementos: Int)
        fun mostrarCargando()
        fun ocultarCargando()
    }


    fun obtenerInformacion() {
        if (!hayPaginaSiguiente) return
        MainScope().launch {
            view.mostrarCargando()
            val data: DataDomain? = withContext(Dispatchers.IO) { personajesInteractor.get(paginaPresentar) }
            if (data != null) {
                view.mostrarTotalElementos(data.info.count)
                hayPaginaSiguiente = (!data.info.next.isNullOrEmpty())
                var listaPersonajes: MutableList<PersonajesUser> = mutableListOf<PersonajesUser>()
                if (!data.results.isNullOrEmpty()) {
                    listaPersonajes = ModelUserMapper.toDataUser(data).personajes.toMutableList()
                    paginaPresentar++
                }
                view.cargarDatos(listaPersonajes)
                view.ocultarCargando()
            }
        }
    }

    fun irDetalle(personajesUser: PersonajesUser) = Navigation.toDetalle(personajesUser)

    fun refreshFavorito(informacion: MutableList<PersonajesUser>) {
        informacion.forEach { it.favorito = (it.id == PersonajesInteractor().getFavorito()) }
        view.refreshAdapter()
    }


}