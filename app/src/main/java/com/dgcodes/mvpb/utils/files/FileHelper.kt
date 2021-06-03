package com.dgcodes.base.utils.files

import android.content.Context
import android.util.Log
import com.dgcodes.base.utils.log.MyLog
import java.io.File

object FileHelper {

    fun create(context: Context, nombre: String): File {
        var file = File("${context.getExternalFilesDir(null)}/${nombre}")
        if (!file.exists()) file.createNewFile()
        return file
    }


    fun escribir(file: File, informacion: String){
        val newLine = "\r\n"
        if (file.canWrite()) file.appendText(informacion+newLine)
    }
}