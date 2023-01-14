package com.corapoyo.corapp.data.service

import android.util.Log
import com.corapoyo.corapp.Const
import com.corapoyo.corapp.data.model.Partner
import com.corapoyo.corapp.data.repository.PartnerRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PartnerService {
    val partnerService = Const.retrofit.create<PartnerRepository>(PartnerRepository::class.java)

    public fun getAllPartners(){
        partnerService.getAllPartners().enqueue(object : Callback<List<Partner>> {
            override fun onResponse(call: Call<List<Partner>>?, response: Response<List<Partner>>?) {
                print("entro")
                val partners = response?.body()
                Log.i("get all successful", Gson().toJson(partners))
                println(partners)
            }

            override fun onFailure(call: Call<List<Partner>>?, t: Throwable?) {
                t?.printStackTrace()
            }

        })
    }

    public fun getAllPartnersByRole(role:String){
        partnerService.getAllPartnersByRole(role).enqueue(object : Callback<List<Partner>>{
            override fun onResponse(call: Call<List<Partner>>?, response: Response<List<Partner>>?) {
                val partners = response?.body()
                Log.i("geta role successful", Gson().toJson(partners))
            }

            override fun onFailure(call: Call<List<Partner>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    public fun getAllPartnersByEmail(email:String){
        partnerService.getAllPartnersByEmail(email).enqueue(object : Callback<List<Partner>>{
            override fun onResponse(call: Call<List<Partner>>?, response: Response<List<Partner>>?) {
                val partners = response?.body()
                Log.i("geta email successful", Gson().toJson(partners))
            }

            override fun onFailure(call: Call<List<Partner>>?, t: Throwable?) {
                t?.printStackTrace()
            }

        })
    }

    public fun getPartnerById(id:String){
        partnerService.getPartnerById(id).enqueue(object : Callback<Partner>{
            override fun onResponse(call: Call<Partner>?, response: Response<Partner>?) {
                val partner = response?.body()
                Log.i("get by id successful", Gson().toJson(partner))
            }

            override fun onFailure(call: Call<Partner>?, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }

    public fun addPartner(document_number:String,name:String,last_name:String,email:String,
                          username:String,account_number:String,password:String,phone:String,role:String,
                          document_type:String){
        var partner: Partner? = Partner(document_number,name,last_name,email,username,account_number,password,phone,role,document_type,false,false)

        partnerService.addPartner(partner).enqueue(object : Callback<Partner>{
            override fun onResponse(call: Call<Partner>?, response: Response<Partner>?) {
                partner = response?.body()
                Log.i("add successful", Gson().toJson(partner))
            }

            override fun onFailure(call: Call<Partner>?, t: Throwable) {
                t?.printStackTrace()
            }

        })

    }

    //fun removePartner(){

    //}

    //fun updatePartner(){

    //}
}