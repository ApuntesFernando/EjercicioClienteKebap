package net.iessochoa.fernandorodriguez.clientkebap.ui

import androidx.compose.runtime.currentComposer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductSize
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables
import net.iessochoa.fernandorodriguez.clientkebap.model.productPrice

open class ClienteKebapViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ClienteKebapUiState())

    val uiState: StateFlow<ClienteKebapUiState> = _uiState.asStateFlow()


    // Funcion para actualizar el tamaño del producto
    fun onSizeSelected(newSize: ProductSize) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    size = newSize
                )
            )
        }
    }

    // Funcion para actualizar el tipo de producto
    fun onProductSelected(type: ProductType) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    productType = type
                )
            )
        }
    }


    // Funcion para actualizar la lista de verduras
    fun onVegetableSelected(newVegetables: Vegetables) {

        _uiState.update { currentState ->
            // Comprobamos si la lista tiene el vegetal
            val ingredientesActualizados =
                if (currentState.order.vegetables.contains(newVegetables)) {
                    currentState.order.vegetables - newVegetables
                } else {
                    currentState.order.vegetables + newVegetables
                }
            currentState.copy(
                order = currentState.order.copy(
                    vegetables = ingredientesActualizados
                )
            )
        }
    }

    // Funcion para actualizar el delivery
    fun onDeliveryChange(delivery: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    delivery = delivery
                )
            )
        }
    }

    // Funcion para actualizar las salsas
    fun onSalsasSelected(salsas: String) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    salsas = salsas
                )
            )
        }
    }


    // Funcion para actualizar las notas
    fun onNotesSelected(notas: String) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    notes = notas
                )
            )
        }
    }


    // Funcion para actualizar el nombre del cliente
    fun onNameSelected(name: String) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    clientName = name
                )
            )
        }
    }


    // Funcion para actualizar el pedido seleccionado y abrirlo en una nueva pantalla de nuevo
    fun onOrderSelected(kebapOrder: KebapOrder) {
        _uiState.update { currentState ->
            currentState.copy(
                order = kebapOrder
            )
        }
    }

    // Funcion para guardar un pedido
    fun onOrderSaved() {

        _uiState.update { currentState ->

            val newOrder = currentState.order.copy(
                basePrice = currentState.order.productPrice()
            )


            // Compruebo si el pedido existe en la lista.
                // Si existe, modifica el existente
                // Si no existe, lo agrega a la lista

            val updatedOrders =
                if (newOrder.id == 0) {
                    // Pedido nuevo
                    currentState.orderList + newOrder.copy(
                        id = currentState.orderList.size + 1
                    )
                } else {
                    // Edita el pedido existente
                    currentState.orderList.map { order ->
                        if (order.id == newOrder.id) newOrder else order
                    }
                }

            currentState.copy(
                orderList = updatedOrders,
                order = KebapOrder()
            )
        }
    }
}

