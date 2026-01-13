package net.iessochoa.fernandorodriguez.clientkebap.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductSize
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables
import net.iessochoa.fernandorodriguez.clientkebap.ui.theme.Typography


@Composable
fun OrderListCard(
    kebapOrder: KebapOrder
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (modifier = Modifier
                .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Pedido numero ${kebapOrder.id}",
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.padding(top = 5.dp))
                Text(
                    text = "Cliente ${kebapOrder.clientName}",
                    style = Typography.bodyLarge
                )
                Spacer(Modifier.padding(top = 5.dp))
                Text(
                    text = "Total: ${kebapOrder.basePrice} €"
                )
            }

            Spacer(Modifier.padding(end = 10.dp))

            Column (modifier = Modifier
                .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "${kebapOrder.productType}",
                    style = Typography.bodyLarge
                )
                Text(
                    text = "${kebapOrder.size}",
                    style = Typography.bodyLarge
                )
            }

            Spacer(Modifier.padding(end = 10.dp))

            Column (modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                        text = "${kebapOrder.vegetables}",
                        style = Typography.bodyLarge,
                        fontSize = 11.sp
                )

            }
        }
    }


}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun previewOrderListCard(){

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

    OrderListCard(kebapOrder)

}

