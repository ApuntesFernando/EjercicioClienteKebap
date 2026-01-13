package net.iessochoa.fernandorodriguez.clientkebap.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.sergiocontreras.doctorround.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductTypeDropDown(
    selected: ProductType,
    optionList: List<ProductType>,
    onProductSelected: (ProductType) -> Unit,
    modifier: Modifier
){

    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded= expanded,
        onExpandedChange = {expanded != expanded}
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selected.name,
            onValueChange = {}, // Porque solo es de lectura
            label = { Text(stringResource(R.string.Tipo_de_pedido)) }, // Nombre que aparece por defecto
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, true)
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false}
        ) {
            optionList.forEach { option : ProductType ->
                DropdownMenuItem(
                    text = {Text(text = option.name)},
                    onClick = {
                        expanded = false
                        onProductSelected(option)
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProdductType(){

    val tipo = ProductType.DURUM

    val productTypes: List<ProductType> = ProductType.values().toList()

    ProductTypeDropDown(
        selected = tipo,
        optionList = productTypes,
        onProductSelected = {  },
        modifier = Modifier
    )

}