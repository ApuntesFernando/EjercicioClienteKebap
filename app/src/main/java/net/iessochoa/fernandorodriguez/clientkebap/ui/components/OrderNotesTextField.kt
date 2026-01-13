package net.iessochoa.fernandorodriguez.clientkebap.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductSize
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables


@Composable
fun OrderNotes(
    onValueChange: (String) -> Unit,
    kebapOrder: KebapOrder
){

    Column() {
        Text(
            text = "Añadir un comentario para el pedido"
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = kebapOrder.notes,
            onValueChange = onValueChange,
            label = {Text(text = "Añade una nota")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Añadir una nota"
                )
            },
            singleLine = false,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun previewOrderNotes(){

    val kebapOrder = KebapOrder(
        id = 1,
        productType = ProductType.DURUM,
        vegetables = listOf(
            Vegetables.TOMATE,
            Vegetables.LECHUGA
        ),
        clientName = "Juan",
        size = ProductSize.MEDIANO,
        basePrice = 6.50,
        notes = "Sin cebolla",
        delivery = true
    )

    OrderNotes(
        onValueChange = {},
        kebapOrder = kebapOrder
    )

}