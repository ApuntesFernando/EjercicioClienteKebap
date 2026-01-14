package net.iessochoa.fernandorodriguez.clientkebap.ui.components

import android.widget.CheckBox
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.fernandorodriguez.clientkebap.model.ProductType
import net.iessochoa.fernandorodriguez.clientkebap.model.Vegetables
import net.iessochoa.fernandorodriguez.clientkebap.ui.theme.Typography


@Composable
fun VegetablesCheckBox(
    lista: List<Vegetables>,
    selectedVegetable: Set<Vegetables>,
    onOptionChecked: (Vegetables) -> Unit,
    modifier: Modifier = Modifier
){

    Column(
        modifier.selectableGroup()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        lista.forEach { option ->
            Row (
                Modifier.height(35.dp)
                    .padding(horizontal = 7.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = (selectedVegetable.contains(option)),
                    onCheckedChange = {onOptionChecked(option)}
                )
                Text(
                    text = option.name,
                    style = Typography.bodyLarge
                )
            }
        }
    }


}




@Preview(showBackground = true,
     showSystemUi = true)
@Composable
fun PreviewVegeteablesCheckBox(){

    val vegetales: List<Vegetables> = Vegetables.values().toList()

    VegetablesCheckBox(
        lista = vegetales,
        selectedVegetable = setOf(),
        onOptionChecked = {}
    )

}





