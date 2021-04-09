package com.example.shopmax.data

data class QuoteRequest(val pickupRequested: Boolean,
                      val plannedShippingDateAndTime: String,
                        val packages: List<ShipmentResponsePackage>,
                        val receiverDetails: ReceiverDetails,
                        val pickupDetails: PickupDetails

)


data class ReceiverDetails( val cityName:String,
                            val address:String)

data class PickupDetails( val cityName:String,
                            val address:String)