package net.iessochoa.fernandorodriguez.clientkebap.ui.components

import android.widget.Space
import android.widget.Switch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.doctorround.R

@Composable
fun SwitchButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.Delivery))
        Spacer(Modifier.padding(start = 50.dp))
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }

}




@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun previewSwitchButton(){


    SwitchButton(
        checked = false,
        onCheckedChange = {}
    )


}