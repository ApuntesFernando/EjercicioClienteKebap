package net.iessochoa.fernandorodriguez.clientkebap.ui

import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductSize
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables

data class ClienteKebapUiState (

    val order: KebapOrder = KebapOrder(),
    val orderList: List<KebapOrder> = emptyList()
){

}