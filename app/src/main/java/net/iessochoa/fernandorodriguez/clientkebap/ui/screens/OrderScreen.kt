package net.iessochoa.fernandorodriguez.clientkebap.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductSize
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables
import net.iessochoa.fernandorodriguez.clientkebap.ui.ClienteKebapViewModel
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.OrderNotes
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.ProductTypeDropDown
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.SalsaTypeDropDown
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.SizeRadioButton
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.SwitchButton
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.VegetablesCheckBox
import net.iessochoa.sergiocontreras.doctorround.R

@Composable
fun OrderScreen(
    viewModel: ClienteKebapViewModel,
    onBack: () -> Unit,

){

    val uiState by viewModel.uiState.collectAsState()

//
//    // Declaro las funciones que llamare a la hora de hacer cambios en el pedido
//    val onProductChanged: (ProductType) -> Unit = { newProduct ->
//        viewModel.onProductSelected(newProduct)
//    }
//
//    val onSizeChenged: (ProductSize) -> Unit = { newSize ->
//        viewModel.onSizeSelected(newSize)
//    }
//
//    val onIngredientChanged: (Vegetables) -> Unit = { newVegetal ->
//        viewModel.onVegetableSelected(newVegetal)
//    }
//
//    val onDeliveryChanged: (Boolean) -> Unit = { delivery ->
//        viewModel.onDeliveryChange(delivery)
//    }
//
//    val onSalsaChanged: (String) -> Unit = { salsa ->
//        viewModel.onSalsasSelected(salsa)
//    }
//
//    val onNotesChanged: (String) -> Unit = { salsa ->
//        viewModel.onNotesSelected(salsa)
//    }

    val productTypes: List<ProductType> = ProductType.values().toList()

    val listaVegetales: List<Vegetables> = Vegetables.values().toList()


    val listaSize: List<ProductSize> = ProductSize.values().toList()

    val listaSalsas : List<String> = stringArrayResource(R.array.salsas).toList()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        ProductTypeDropDown(
            selected = uiState.order.productType,
            optionList = productTypes,
            onProductSelected = {viewModel.onProductSelected(it)},
            modifier = Modifier
        )

        Spacer(Modifier.padding(vertical = 6.dp))

        VegetablesCheckBox(
            lista = listaVegetales,
            selectedVegetable = uiState.order.vegetables.toSet(),
            onOptionChecked = {viewModel.onVegetableSelected(it)}
        )

        Spacer(Modifier.padding(vertical = 6.dp))

        SalsaTypeDropDown(
            selected = uiState.order.salsas,
            optionList = listaSalsas,
            onProductSelected = {viewModel.onSalsasSelected(it)},
            modifier = Modifier
        )

        Spacer(Modifier.padding(vertical = 6.dp))

        SizeRadioButton(
            listaSize = listaSize,
            sizeSeleccionado = uiState.order.size,
            onSizeSeleccionado = {viewModel.onSizeSelected(it)}
        )

        Spacer(Modifier.padding(vertical = 6.dp))

        SwitchButton(
            checked = uiState.order.delivery,
            onCheckedChange = {viewModel.onDeliveryChange(it)}
        )

        OrderNotes(
            onValueChange = {viewModel.onNotesSelected(it)},
            kebapOrder = uiState.order
        )

        Spacer(Modifier.padding(vertical = 6.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.onOrderSaved()
                Toast.makeText(
                    context,
                    "Se ha guardado el pedido",
                    Toast.LENGTH_SHORT
                ).show()
                onBack()
            }
        ) {
            Text("Guardar Pedido")
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun wqeqweqwe(){
    OrderScreen(
        viewModel = ClienteKebapViewModel(),
        onBack = {}
    )
}

