package com.dgcodes.base.utils.fechas

import java.text.SimpleDateFormat
import java.util.*

object DatesHelper {
    val FORMATO_HORA: String = "HH:mm:ss"
    val FORMATO_FECHA: String = "HH:mm:ss"
    val FORMATO_FECHA_HORA: String = "dd-MM-yyyy hh:mm:ss"

    fun getAhora(formato: String = FORMATO_FECHA_HORA) = SimpleDateFormat(formato).format(Date())
    fun getHora(formato: String = FORMATO_HORA) = SimpleDateFormat(formato).format(Date())
    fun getFecha(formato: String = FORMATO_FECHA) = SimpleDateFormat(formato).format(Date())

}