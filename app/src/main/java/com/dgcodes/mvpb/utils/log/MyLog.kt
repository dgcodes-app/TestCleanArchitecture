package com.dgcodes.base.utils.log

import android.util.Log

object MyLog {

    val TAG: String = "MAXAM" //Tag para los log
    var MOSTRAR_TIPO_LOG: Boolean = true //indica si cuando se muestra el mensaje mostramos el tipo D, V, I, E,...
    var MOSTRAR_NOMBRE_FICHERO: Boolean = false
    var MOSTRAR_NOMBRE_CLASE: Boolean = true
    var MOSTRAR_NOMBRE_CLASEA_ABRV: Boolean = true
    var MOSTRAR_NOMBRE_METODO: Boolean = true
    var MOSTRAR_NUMERO_LINEAS: Boolean = true
    var MOSTRAR_ES_NATIVO: Boolean = false
    val ALMACENAR_LOG_FICHERO: Boolean = true //almacenamos las salidas de log en un fichero diario...

    init {
        Log.v(TAG, "Informacion inicial del log")
    }

    //LOG ERROR
    fun e(informacion: Any) = mostrarLog(TIPOS_LOG.ERROR, informacion)

    //LOG VERBOSE
    fun v(informacion: Any) = mostrarLog(TIPOS_LOG.VERBOSE, informacion)

    //LOG DEBUG
    fun d(informacion: Any) = mostrarLog(TIPOS_LOG.DEBUG, informacion)

    //LOG INFORMATION
    fun i(informacion: Any) = mostrarLog(TIPOS_LOG.INFO, informacion)

    //LOG WARNING
    fun w(informacion: Any) = mostrarLog(TIPOS_LOG.WARNING, informacion)

    //LOG CUADRO
    fun c(informacion: Any) = dibujarCuadro(informacion as String)

    //LOG CUADRO GRUESO
    fun dc(informacion: Any) = dibujarCuadro(informacion as String, "■", "■", "■", "■", "■", "■")

    //LOG CUADRO ASTERISCOS
    fun ast(informacion: Any) = dibujarCuadro(informacion as String, "*", "*", "*", "*", "*", "*")

    //LOG CUADO PUNTOS
    fun p(informacion: Any) = dibujarCuadro(informacion as String, "·", "·", "·", "·", "·", "·")

    //Pasa varias variables y lo muestas
    fun vs(vararg element: Any) {
        element.forEachIndexed { index, elemento ->
            if (elemento is Array<*> || elemento is Collection<*>) {
                lista(elemento)
            } else {
                d("$index : ${elemento.toString()}")
            }
            s()
        }
    }

    //Muestra una linea de careactres_
    fun s(ch: String = "_", longitud: Int = 100) = MyLog.d(ch.repeat(longitud))

    //Muestra una lista (util para arrays y colleciones -list | mutablelist-)
    fun lista(lista: Any?, titulo: String = "") {
        if (lista == null ) {
            e("Lista nula")
            s(".")
            return
        }
        if (!titulo.isBlank()) c(titulo)
        if (lista is Array<*>) lista.forEachIndexed { index, any -> d("[$index] ${any.toString()}") }
        if (lista is Collection<*>) lista.forEachIndexed { index, any -> d("[$index] ${any.toString()}") }
        s()
    }

    //Muestra toda la traza que se ha producido
    fun mostrarTrazaCompleta() {
        val st: List<StackTraceElement> = Thread.currentThread().stackTrace.toList()
        var contador = 0
        c("Incio Traza")
        st.forEach {
            if (dameIndiceTraza() == contador) {
                MyLog.e("[$contador] ${dameInformacionTraza(it)}")
            } else {
                MyLog.v("[$contador] ${dameInformacionTraza(it)}")
            }

            contador++
        }
        MyLog.s()
    }

    //obtiene la traza dado un indicador
    private fun dameTrazaOrigen(n: Int = dameIndiceTraza()): StackTraceElement = Thread.currentThread().stackTrace.toList().get(n)

    //Muestra la informacion en un string de la traza
    private fun dameInformacionTraza(st: StackTraceElement = dameTrazaOrigen()): String {
        var informacion: String = ""
        if (MOSTRAR_NOMBRE_FICHERO) informacion = "$informacion ${st.fileName}]"
        if (MOSTRAR_NOMBRE_CLASE) {
            var nombreClase = st.className
            if (MOSTRAR_NOMBRE_CLASEA_ABRV) nombreClase = nombreClase.split(".").last()
            informacion = "$informacion ${nombreClase}"
        }
        if (MOSTRAR_NOMBRE_METODO) informacion = "$informacion -> ${st.methodName}"
        if (MOSTRAR_NUMERO_LINEAS) informacion = "$informacion(${st.lineNumber})"
        if (MOSTRAR_ES_NATIVO) informacion = "$informacion ${st.isNativeMethod}"
        return informacion //    val st: StackTraceElement = Thread.currentThread().stackTrace.toList().get(INDICE_TRAZA_ORIGEN)
    }

    //Obtoiene el indioce desde donde se realiza la llamada a los metodos de MyLog
    private fun dameIndiceTraza(): Int {
        var localizadaLlamadaMyLog: Boolean = false
        val st: List<StackTraceElement> = Thread.currentThread().stackTrace.toList()
        var contador = 0
        st.forEach {
            if (it.className.contains("MyLog")) localizadaLlamadaMyLog = true
            if (!it.className.contains("MyLog") && localizadaLlamadaMyLog) return contador;
            contador++
        }
        return contador
    }

    //Metodo para dibujar el cuadro
    private fun dibujarCuadro(cadena: String, supDerecha: String = "╔", supIzquieda: String = "╗", infDerecha: String = "╚", infIzquierda: String = "╝", vertical: String = "║", horizontal: String = "═") {
        val paddingInformacion: Int = 4
        val paddingStr = " ".repeat(paddingInformacion)
        val longitudTexto = 2 + cadena.length + (paddingInformacion * 2)
        MyLog.d("$supDerecha${horizontal.repeat(longitudTexto)}$supIzquieda")
        MyLog.d("$vertical$paddingStr $cadena $paddingStr$vertical")
        MyLog.d("$infDerecha${horizontal.repeat(longitudTexto)}$infIzquierda")
    }

    //Guarda la informacion del log en un fichero
    private fun almacenarFichero(txt: String) = MyLogFicheros.guardar(txt)

    //Muestra el log por el Logcar, realiza la llamada a los metodos originales de Android
    private fun mostrarLog(tipo: TIPOS_LOG, informacion: Any): Int {
        var txt = "${dameInformacionTraza()}:${informacion.toString()}"
        if (MOSTRAR_TIPO_LOG) txt = tipo.toString().substring(0, 1) + "/" + txt

        //comprobamos si debemos almacenar la linea en el un fichero para almaenarlo
        if (ALMACENAR_LOG_FICHERO) almacenarFichero(txt)

        //mostamos log dependiendo del tipo de severidad que mostremos.
        return when (tipo) {
            TIPOS_LOG.ERROR -> Log.e(TAG, txt)
            TIPOS_LOG.VERBOSE -> Log.v(TAG, txt)
            TIPOS_LOG.DEBUG -> Log.d(TAG, txt)
            TIPOS_LOG.INFO -> Log.i(TAG, txt)
            TIPOS_LOG.WARNING -> Log.w(TAG, txt)
            TIPOS_LOG.ASSERT -> Log.v(TAG, txt)
        }
    }
}