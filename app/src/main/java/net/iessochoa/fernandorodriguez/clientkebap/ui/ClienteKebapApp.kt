package net.iessochoa.fernandorodriguez.clientkebap.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.fernandorodriguez.clientkebap.R
import net.iessochoa.fernandorodriguez.clientkebap.ui.navigation.KebabListDestination
import net.iessochoa.fernandorodriguez.clientkebap.ui.navigation.KebabMainDestination
import net.iessochoa.fernandorodriguez.clientkebap.ui.navigation.KebabNavHost
import net.iessochoa.fernandorodriguez.clientkebap.ui.navigation.KebabOrderDestination



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteKebapApp(
    viewModel: ClienteKebapViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){

    // Esta declaracion es para mostrar los titulos de la pantalla dependiendo de en cual se encuentre
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val currentScreenTittle = when(currentRoute){
        KebabMainDestination.route -> stringResource(KebabMainDestination.tittleRes)
        KebabOrderDestination.route -> stringResource(KebabOrderDestination.tittleRes)
        KebabListDestination.route -> stringResource(KebabListDestination.tittleRes)
        else -> stringResource(R.string.app_name)
    }

    val canNavigateBack = navController.previousBackStackEntry != null

    Scaffold (
        topBar = {
            KebapOrderTopAppBar(
                title = currentScreenTittle,
                canNavigateBack = canNavigateBack,
                navigateUp = {navController.navigateUp()}
            )
        }
    ) { innerPadding ->

        KebabNavHost(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )


    }

}


// DECLARACION DEL TOP BAR CON SU ICONO DE FLECHA PARA VOLVER ATRAS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KebapOrderTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {


    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.app_name)
                    )
                }
            }
        }
    )
}

