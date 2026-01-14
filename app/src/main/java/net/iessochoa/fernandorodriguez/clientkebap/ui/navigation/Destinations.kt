package net.iessochoa.fernandorodriguez.clientkebap.ui.navigation

import androidx.compose.ui.res.stringResource
import androidx.navigation.Navigation
import net.iessochoa.fernandorodriguez.clientkebap.R

// Declaracion de las propiedades de las rutas que va a tener la aplicacion
interface NavigationDestination{
    val route: String
    val tittleRes: Int
}


// Ruta de pantalla principal
object KebabMainDestination : NavigationDestination{
    override val route = "MainScreen"
    override val tittleRes = R.string.MainScreen

}

// Ruta de pantalla de pedido
object KebabOrderDestination : NavigationDestination{
    override val route = "OrderScreen"
    override val tittleRes = R.string.OrderScreen

}

// Ruta de pantalla de pedidos
object KebabListDestination : NavigationDestination{
    override val route = "ListScreen"
    override val tittleRes = R.string.ListScreen

}
