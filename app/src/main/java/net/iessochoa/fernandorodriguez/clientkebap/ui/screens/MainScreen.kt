package net.iessochoa.fernandorodriguez.clientkebap.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.fernandorodriguez.clientkebap.R
import net.iessochoa.fernandorodriguez.clientkebap.ui.ClienteKebapViewModel
import net.iessochoa.fernandorodriguez.clientkebap.ui.theme.ClientKebapTheme
import net.iessochoa.fernandorodriguez.clientkebap.ui.theme.Typography


@Composable
fun MainScreen(
    // viewModel: ClienteKebapViewModel = viewModel(), // Creo que no se usa
    onButtonClickOrder : () -> Unit,
    onButtonClickList : () -> Unit,
    modifier: Modifier = Modifier
){


    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {


        Button(
            onClick = { onButtonClickOrder() }
        ) {
            Text(
                text = stringResource(R.string.Realizar_pedido),
                style = Typography.headlineMedium,
                fontSize = 22.sp
            )
        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Button(
            onClick = { onButtonClickList() }
        ) {
            Text(
                text = stringResource(R.string.Ver_pedidos),
                style = Typography.headlineMedium,
                fontSize = 22.sp
            )
        }


    }







}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewMainScreen(){

    ClientKebapTheme {
       // MainScreen()
    }


}