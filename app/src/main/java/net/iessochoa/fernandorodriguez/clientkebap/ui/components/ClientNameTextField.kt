package net.iessochoa.fernandorodriguez.clientkebap.ui.components

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
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder

@Composable
fun ClientName(
    onValueChange: (String) -> Unit,
    kebapOrder: KebapOrder
){

    Column() {
        Text(
            text = "Introduce tu nombre"
        )
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = kebapOrder.clientName,
            onValueChange = onValueChange,
            label = {Text(text = "Introduce tu nombre")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Introduce tu nombre"
                )
            },
            singleLine = false,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }

}