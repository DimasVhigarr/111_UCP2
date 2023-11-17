@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.ujian2.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ujian2.data.SumberData.dosen

enum class PengelolaHalaman {
    Home,
    Formulir,
    Detail
}

@Composable
fun UjianApp(
    viewModel: ContactViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
){
    Scaffold {innerpadding ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(
            navController = navHostController,
            startDestination = PengelolaHalaman.Formulir.name,
            modifier = Modifier.padding(innerpadding)
        ){
            composable(route = PengelolaHalaman.Home.name){
                HalamanHome (
                    onNextButtonClicked = {
                        navHostController.navigate(PengelolaHalaman.Formulir.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Formulir.name){
                val context = LocalContext.current
                HalamanSatu(
                    pilihanDosen = dosen.map {id -> context.resources.getString(id)},
                    onSelectionChanged = {},
                    onSubmitButtonClicked = {
                        viewModel.setContact(it)
                        navHostController.navigate(PengelolaHalaman.Detail.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Detail.name){
                HalamanHasil(
                    contactUiState = uiState,
                    onBackButtonclicked = {},
                )
            }
        }
    }
}