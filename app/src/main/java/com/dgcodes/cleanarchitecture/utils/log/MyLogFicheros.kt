package com.dgcodes.base.utils.log

import android.content.Context

import com.dgcodes.base.utils.fechas.DatesHelper
import com.dgcodes.base.utils.files.FileHelper
import com.dgcodes.cleanarchitecture.Init


object MyLogFicheros {
    var context: Context? = Init.applicationContext()

    //variables extras para gestionar la informacion que se almacena en fichero
    var MOSTRAR_TIEMPO: Boolean = true

    fun guardar(informacion: String) {
        var info: String = informacion
        if (MOSTRAR_TIEMPO) info = DatesHelper.getAhora("yyyy-MM-dd HH:mm:ss") + " " + info
        val nombreFichero = DatesHelper.getAhora("YYYYmmdd") + ".log"
        val file = FileHelper.create(context!!, nombreFichero)
        FileHelper.escribir(file, info)

    }
}
