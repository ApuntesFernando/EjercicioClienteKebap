package net.iessochoa.fernandorodriguez.clientkebap.data

import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder

object OrderRepository {

    private val orders = mutableListOf<KebapOrder>()

    fun getOrder(): List<KebapOrder> = orders

    fun updateOrder(updatedOrder: KebapOrder){
        val index = orders.indexOfFirst { it.id == updatedOrder.id }
        if (index != -1){
            orders[index] = updatedOrder
        }
    }

}