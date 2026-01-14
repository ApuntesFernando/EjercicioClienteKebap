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
        composable(route = KebabMainDestination.route){
            MainScreen(
                onButtonClickOrder = {navController.navigate(KebabOrderDestination.route)},
                onButtonClickList = {navController.navigate(KebabListDestination.route)}
            )
        }

        composable(route = KebabOrderDestination.route){
            OrderScreen(
                viewModel = viewModel,
                onBack = {navController.popBackStack()} // Vuelve atras
            )
        }

        composable (route = KebabListDestination.route){
            ResumeScreen(
                viewModel = viewModel,
                onOrderClick = {navController.navigate(KebabOrderDestination.route)}
            )
        }


    }
}