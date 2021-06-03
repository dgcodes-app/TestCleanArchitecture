package com.dgcodes.mvpb.presentacion.view.acitivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dgcodes.base.utils.log.MyLog
import com.dgcodes.mvpb.Init
import com.dgcodes.mvpb.databinding.ActivityListaInformacionBinding
import com.dgcodes.mvpb.presentacion.adapters.AdapterListaInformacion
import com.dgcodes.mvpb.presentacion.adapters.TipoAccion
import com.dgcodes.mvpb.presentacion.model.PersonajesUser
import com.dgcodes.mvpb.presentacion.presenter.ListaPresenter

class ListaActivity : BaseActivity(), ListaPresenter.IViewPresenter {

    lateinit var binding: ActivityListaInformacionBinding
    lateinit var presenter: ListaPresenter
    lateinit var adapter: AdapterListaInformacion

    companion object {
        val COLUMNAS: Int = 3
        fun getIntentActivity(): Intent = Intent(Init.applicationContext(), ListaActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarRecycler()
        presenter = ListaPresenter(this)
        presenter.obtenerInformacion()
    }


    fun inicializarRecycler() {
        adapter = AdapterListaInformacion(context) { tipoAccion, personajesUser ->
            when (tipoAccion) {
                TipoAccion.CLICK -> presenter.irDetalle(personajesUser)
                TipoAccion.LONG_CLICK -> MyLog.d("... sin capturar ...")
            }

        }


        binding.listaInformacion.adapter = adapter
        binding.listaInformacion.layoutManager = GridLayoutManager(context, COLUMNAS, GridLayoutManager.VERTICAL, false)

        //vamos mirando el scroll que vamos a utrilizar para en el momentop en eque lleguemos al final del scroll realizar una nueva peticion de datos.
        binding.listaInformacion.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) presenter.obtenerInformacion()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.refreshFavorito(adapter.informacion)
    }


    override fun mostrarTotalElementos(numeroElementos: Int) {
        binding.txtTotalElementos.text = " $numeroElementos personajes"
    }

    override fun cargarDatos(informacion: List<PersonajesUser>) {
        adapter.setData(informacion)
    }


    override fun refreshAdapter() {
        adapter.notifyDataSetChanged()
    }

    override fun mostrarCargando() {
        binding.prgLoading.visibility = View.VISIBLE
    }

    override fun ocultarCargando() {
        binding.prgLoading.visibility = View.GONE
    }
}