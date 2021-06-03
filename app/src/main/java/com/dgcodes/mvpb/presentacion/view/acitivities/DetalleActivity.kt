package com.dgcodes.mvpb.presentacion.view.acitivities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.dgcodes.mvpb.Init
import com.dgcodes.mvpb.databinding.ActivityDetalleBinding
import com.dgcodes.mvpb.presentacion.extension.glide
import com.dgcodes.mvpb.presentacion.model.LocalizacionesUser
import com.dgcodes.mvpb.presentacion.model.PersonajesUser
import com.dgcodes.mvpb.presentacion.navigation.Navigation
import com.dgcodes.mvpb.presentacion.presenter.DetallePresenter

class DetalleActivity : BaseActivity(), DetallePresenter.IDetallePresenter {

    lateinit var presenter: DetallePresenter
    lateinit var binding: ActivityDetalleBinding
    lateinit var personajesUser: PersonajesUser

    companion object {
        fun getIntentActivity(personajesUser: PersonajesUser): Intent =
            Intent(Init.applicationContext(), DetalleActivity::class.java).putExtra(Navigation.TAG_PERSONAJE, personajesUser).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        presenter = DetallePresenter(this)
        personajesUser = intent.extras!!.get(Navigation.TAG_PERSONAJE) as PersonajesUser
        presenter.obtenerInformacion(personajesUser)
    }

    private fun setupView() {
        binding.btnFavorito.setOnClickListener { presenter.marcaFavorito(personajesUser, binding.btnFavorito.isChecked) }
        binding.btnVolver.setOnClickListener { finish() }
    }

    override fun mostrarDatosPantalla(personajesUser: PersonajesUser) {
        binding.imagen.glide(personajesUser.image)
        binding.txtNombrePersonaje.text = personajesUser.name
        binding.btnFavorito.isChecked = personajesUser.favorito
    }

    override fun mostrarDatosLocalizacion(localizacionesUser: LocalizacionesUser) {
        binding.txtNombreLocalizacion.text = localizacionesUser.name
        binding.txtDimension.text = localizacionesUser.dimension
        binding.txtTipo.text = localizacionesUser.type
    }


    override fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
