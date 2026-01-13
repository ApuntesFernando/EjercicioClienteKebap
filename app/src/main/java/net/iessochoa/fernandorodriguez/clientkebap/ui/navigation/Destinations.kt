package net.iessochoa.fernandorodriguez.clientkebap.ui.navigation

import androidx.navigation.Navigation
import net.iessochoa.sergiocontreras.doctorround.R


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