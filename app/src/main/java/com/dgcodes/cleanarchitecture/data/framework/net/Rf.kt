package com.dgcodes.cleanarchitecture.data.framework.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Rf {

    fun get(): RestApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit.create(RestApi::class.java)
    }

   /* fun getPage(): Data? =  getRetrofit().getCharacter().execute().body()

    fun getPageN(pagina: Int): Data? =  getRetrofit().getCharacterPage(pagina).execute().body()

    fun getLocation(idLocalizacion: Int): Locations? = getRetrofit().getLocation(idLocalizacion).execute().body()*/

}