package com.dgcodes.mvpb

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.dgcodes.base.utils.log.MyLog
import com.dgcodes.mvpb.data.di.modulesData
import com.dgcodes.mvpb.data.entities.Data
import com.dgcodes.mvpb.data.framework.sp.SharedPreferencesHelper
import com.dgcodes.mvpb.domain.di.modulesDomain
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlinx.coroutines.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
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