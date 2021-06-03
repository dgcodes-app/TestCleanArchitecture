package com.dgcodes.mvpb.presentacion.adapters

enum class TipoAccion { CLICK, LONG_CLICK }

interface ListenerUserAction<T> {
    fun action(accion: TipoAccion, objecto: T)
}