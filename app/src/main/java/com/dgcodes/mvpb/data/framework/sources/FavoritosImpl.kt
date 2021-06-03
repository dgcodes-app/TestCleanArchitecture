package com.dgcodes.mvpb.data.framework.sources

import com.dgcodes.mvpb.data.framework.sp.SharedPreferencesHelper
import com.dgcodes.mvpb.data.repository.FavoritosSource

class FavoritosImpl : FavoritosSource {
    val FAVORITO: String = "ID_FAVORITO"

    override fun getFavorito(): Int = SharedPreferencesHelper.getInt(FAVORITO)
    override fun putFavorito(idFavorito: Int) = SharedPreferencesHelper.setInt(FAVORITO, idFavorito)

}