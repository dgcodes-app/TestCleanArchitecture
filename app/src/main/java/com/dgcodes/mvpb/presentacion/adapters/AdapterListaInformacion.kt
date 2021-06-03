package com.dgcodes.mvpb.presentacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dgcodes.base.utils.log.MyLog
import com.dgcodes.mvpb.R
import com.dgcodes.mvpb.databinding.ItemInformacionBinding
import com.dgcodes.mvpb.presentacion.extension.glide
import com.dgcodes.mvpb.presentacion.model.PersonajesUser

class AdapterListaInformacion(private val context: Context, val v: (TipoAccion, PersonajesUser) -> Unit/* private val listener: ListenerUserAction<PersonajesUser>*/) : RecyclerView.Adapter<AdapterListaInformacion.ViewHolder>() {

    var informacion: MutableList<PersonajesUser> = mutableListOf()

    fun setData(data: List<PersonajesUser>) {
        informacion.addAll(data)
        notifyDataSetChanged()
    }

    fun vaciar() {
        informacion = mutableListOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_informacion, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(informacion.get(position), v)


    override fun getItemCount(): Int = informacion.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bindingItem: ItemInformacionBinding = ItemInformacionBinding.bind(itemView)
        fun bind(personaje: PersonajesUser, v: (TipoAccion, PersonajesUser) -> Unit) {


            MyLog.d(personaje.image)
            bindingItem.imagen.glide(personaje.image)
            bindingItem.txtNombre.text = personaje.name
            bindingItem.imgFavorito.visibility = if (personaje.favorito) View.VISIBLE else View.INVISIBLE
            //bindingItem.txtFav.text = personaje.favorito.toString()


            bindingItem.panel.setOnClickListener {
                //listener.action(TipoAccion.CLICK, personaje)ç
                v.invoke(TipoAccion.CLICK, personaje)
            }
        }
    }
}