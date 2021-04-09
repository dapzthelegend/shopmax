package com.example.shopmax.data

data class ShipmentResponse( val status:Boolean,
                             val message:String,
                             val data: ShipmentResponseData,
                             val errors: List<ShipmentResponseError>
                            )


data class ShipmentResponseData(val shipments: List<ShipmentResponseShipments>,
                                )

data class ShipmentResponsePackage(val weight:Double,
                                   val name:String,
                                   val dimensions: Dimension
                                    )

data class ShipmentResponseShipments(val id:String,
                                     val charges:Double,
                                     val packages: List<ShipmentResponsePackage>,
                                     val tracking_id:String,
                                     val status:String,
                                    )
data class ShipmentResponseError(val message: String)

data class Dimension(   val length: Double,
                        val height:Double,
                        val width:Double)






