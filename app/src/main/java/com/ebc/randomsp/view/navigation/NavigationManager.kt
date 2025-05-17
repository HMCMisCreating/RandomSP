package com.ebc.randomsp.view.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.ebc.randomsp.enumerators.ViewIDs
import com.ebc.randomsp.view.components.randomsp.StartGuestScreen
import com.ebc.randomsp.view.components.randomsp.StartLoggedScreen
import com.ebc.randomsp.viewmodel.RandomSPViewModel

/*
import com.ebc.cupcakemaker.enumerators.ViewIDs
import com.ebc.cupcakemaker.view.components.cupcakewizard.SelectFlavorScreen
import com.ebc.cupcakemaker.view.components.cupcakewizard.StartOrderScreen
import com.ebc.cupcakemaker.viewmodel.CupcakeMakerViewModel
 */

// Crear función para el topbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomSPAppBar() {
    CenterAlignedTopAppBar(
        title = {"Título"},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )

}


// Crear el nav manager
@Composable
fun NavigationManager(randomSPViewModel: RandomSPViewModel) {
    val navController = rememberNavController();

    Scaffold(
        topBar = {RandomSPAppBar()},
        bottomBar = {Text(text = "I'm the bottom container")}

    ) {
        NavHost(
            navController = navController,
            startDestination = ViewIDs.StartGuess.id,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable("Home") {
                Text(text = "Placeholder Home")
            }
            composable (ViewIDs.StartGuess.id) {
                StartGuestScreen(navController, randomSPViewModel)
            }
            composable (ViewIDs.StartUser.id) {
                StartLoggedScreen(navController, randomSPViewModel)
            }
        }
    }
}

