package net.iessochoa.fernandorodriguez.clientkebap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.fernandorodriguez.clientkebap.ui.ClienteKebapViewModel
import net.iessochoa.fernandorodriguez.clientkebap.ui.screens.MainScreen
import net.iessochoa.fernandorodriguez.clientkebap.ui.screens.OrderScreen
import net.iessochoa.fernandorodriguez.clientkebap.ui.screens.ResumeScreen


// Composable que se va a encargar de redirigir las pantallas
@Composable
fun KebabNavHost(
    navController: NavHostController,
    viewModel: ClienteKebapViewModel,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = KebabMainDestination.route,
        modifier = modifier
    ) {

        // Ruta pantalla principal que lleva o a la lista de realizar pedido o a la de listar pedidos
        composable(route = KebabMainDestination.route){
            MainScreen(
                onButtonClickOrder = {navController.navigate(KebabOrderDestination.route)},
                onButtonClickList = {navController.navigate(KebabListDestination.route)}
            )
        }


        // Ruta pantalla de creacion de pedido para que vuelva a la pantalla anterior (onBack)
        composable(route = KebabOrderDestination.route){
            OrderScreen(
                viewModel = viewModel,
                onBack = {navController.popBackStack()} // Vuelve atras
            )
        }

        // Ruta desde la lista de pedidos que te lleva a la ruta de creacion del pedido seleccionado
        composable (route = KebabListDestination.route){
            ResumeScreen(
                viewModel = viewModel,
                onOrderClick = {navController.navigate(KebabOrderDestination.route)}
            )
        }

    }
}