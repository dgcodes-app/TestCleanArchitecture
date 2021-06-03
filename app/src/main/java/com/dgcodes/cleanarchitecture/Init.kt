package com.dgcodes.cleanarchitecture

import android.app.Application
import android.content.Context
import com.dgcodes.cleanarchitecture.data.di.modulesData
import com.dgcodes.cleanarchitecture.domain.di.modulesDomain
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlinx.coroutines.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Init : Application() {

    lateinit var context: Context

    init {
        instance = this
    }

    companion object {
        private var instance: Init? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        inicilazacionKoin()
        initCalligraphy()
    }

    fun initCalligraphy() {

        //cargamos una fuente similalr a la de la serieAGENCYR
        ViewPump.init(
            ViewPump.builder().addInterceptor(CalligraphyInterceptor(CalligraphyConfig.Builder().setDefaultFontPath("fonts/AGENCYR.TTF").build())).build()
                     )
    }

    fun inicilazacionKoin() {
        startKoin {
            //androidLogger()
            androidContext(this@Init)
            modules(modulesData, modulesDomain)
        }

    }
}