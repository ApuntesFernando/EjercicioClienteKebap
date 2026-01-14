package net.iessochoa.fernandorodriguez.clientkebap.ui.navigation

import androidx.compose.ui.res.stringResource
import androidx.navigation.Navigation
import net.iessochoa.fernandorodriguez.clientkebap.R


interface NavigationDestination{
    val route: String
    val tittleRes: Int
}

object KebabMainDestination : NavigationDestination{
    override val route = "MainScreen"
    override val tittleRes = R.string.MainScreen

}

object KebabOrderDestination : NavigationDestination{
    override val route = "OrderScreen"
    override val tittleRes = R.string.OrderScreen

}

object KebabListDestination : NavigationDestination{
    override val route = "ListScreen"
    override val tittleRes = R.string.ListScreen

}

//object KebabShowOrderDestination : NavigationDestination{
//    override val route = "Kebab_showOrder"
//    override val tittleRes = R.string.ShowScreen
//
//}