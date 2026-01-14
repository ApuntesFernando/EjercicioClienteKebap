package net.iessochoa.fernandorodriguez.clientkebap.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.fernandorodriguez.clientkebap.model.KebapOrder
import net.iessochoa.fernandorodriguez.clientkebap.ui.ClienteKebapViewModel
import net.iessochoa.fernandorodriguez.clientkebap.ui.components.OrderListCard


@Composable
fun ResumeScreen(
    viewModel: ClienteKebapViewModel = viewModel(),
    onOrderClick: (KebapOrder) -> Unit,
    modifier: Modifier = Modifier
){
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(uiState.orderList) { order ->
            OrderListCard(
                kebapOrder = order,
                onClick = {
                    viewModel.onOrderSelected(order)
                    onOrderClick(order)
                }

            )
        }

    }
}