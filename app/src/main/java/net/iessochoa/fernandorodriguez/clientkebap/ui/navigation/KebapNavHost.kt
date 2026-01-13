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
                onButtonClickOrder = {navController.navigate("OrderScreen")},
                onButtonClickList = {navController.navigate("ListScreen")}
            )
        }

        composable(route = KebabOrderDestination.route){
            // OrderScreen()
        }

        composable (route = KebabListDestination.route){
            ResumeScreen()
        }


    }
}