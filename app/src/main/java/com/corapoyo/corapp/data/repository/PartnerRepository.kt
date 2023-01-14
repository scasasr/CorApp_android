package com.corapoyo.corapp.data.repository

import com.corapoyo.corapp.data.model.Partner
import retrofit2.Call
import retrofit2.http.*

interface PartnerRepository {
    @GET(value = "partners/all")
    fun getAllPartners(): Call<List<Partner>>

    @GET(value = "partners/all/{id}")
    fun getAllPartnersByRole(@Path(value = "id") id:String):Call<List<Partner>>

    @GET(value = "partners/all/{email}")
    fun getAllPartnersByEmail(@Path(value = "email") email:String):Call<List<Partner>>

    @GET(value = "partners/{id}")
    fun getPartnerById(@Path(value = "id") id:String):Call<Partner>

    @POST(value = "partners/add" )
    fun addPartner(@Body partner: Partner?):Call<Partner>

    @DELETE(value = "partners/{id}")
    fun removePartner(@Path(value = "id") id:String):Call<Partner>

    @PATCH(value = "partners/{id}")
    fun updatePartner(@Path(value = "id") id:String,@Body partner: Partner?):Call<Partner>
}