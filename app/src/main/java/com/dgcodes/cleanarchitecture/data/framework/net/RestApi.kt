package com.dgcodes.cleanarchitecture.data.framework.net

import com.dgcodes.cleanarchitecture.data.entities.Data
import com.dgcodes.cleanarchitecture.data.entities.Locations
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {
    @GET("character")
    fun getCharacter(): Call<Data>

    @GET("character/")
    fun getCharacterPage(@Query("page") page: Int) : Call<Data>

    @GET("location/{location_id}")
    fun getLocation(@Path("location_id") locationId: Int) : Call<Locations>

}