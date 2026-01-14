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

    fun onSizeSelected(newSize: ProductSize) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    size = newSize
                )
            )
        }
    }

    fun onProductSelected(type : ProductType){

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    productType = type
                )
            )
        }
    }

    fun onVegetableSelected(newVegetables: Vegetables) {

        _uiState.update { currentState ->
            // Comprobamos si la lista tiene el vegetal
            val ingredientesActualizados = if (currentState.order.vegetables.contains(newVegetables)){
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

    fun onDeliveryChange(delivery: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    delivery = delivery
                )
            )
        }
    }

    fun onSalsasSelected(salsas: String) {

        _uiState.update { currentState ->
            currentState.copy(
                order = currentState.order.copy(
                    salsas = salsas
                )
            )
        }
    }

        fun onNotesSelected(notas: String) {

            _uiState.update { currentState ->
                currentState.copy(
                    order = currentState.order.copy(
                        notes = notas
                    )
                )
            }
        }

    fun onNameSelected(name: String){

            _uiState.update { currentState ->
                currentState.copy(
                    order = currentState.order.copy(
                        clientName = name
                    )
                )
            }
    }

    fun onOrderSelected(kebapOrder: KebapOrder){
       _uiState.update { currentState ->
           currentState.copy(
               order = kebapOrder
           )
       }
    }


        fun onOrderSaved() {

            _uiState.update { currentState ->

                val newOrder = currentState.order.copy(
                    id = currentState.orderList.size + 1,
                    basePrice = currentState.order.productPrice()
                )

                currentState.copy(
                    orderList = currentState.orderList + newOrder,
                    order = KebapOrder()
                )
            }
        }
    }

