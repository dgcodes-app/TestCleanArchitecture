package com.dgcodes.mvpb.data.framework.sp

import android.content.Context
import android.content.SharedPreferences
import com.dgcodes.mvpb.Init

object SharedPreferencesHelper {
    private val NAME = "PRFS"

    private val preferences: SharedPreferences = Init.applicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE)

    fun setInt(nombre: String, valor: Int) = preferences.edit().putInt(nombre, valor).apply()

    fun getInt(nombre: String) = preferences.getInt(nombre, 0)


}

