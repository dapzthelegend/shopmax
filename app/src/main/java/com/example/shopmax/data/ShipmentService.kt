package com.example.shopmax.data

import retrofit2.http.GET

interface ShipmentService{


    companion object{

        const val GET_SHIPMENTS = "shipments"

    }


    @GET(GET_SHIPMENTS)
    suspend fun getShipments(): ShipmentResponse


}