package com.example.dartsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dartsapp.data.DataSource.modeOptions
import com.example.dartsapp.data.DataSource.zeroOneModeOptions

import com.example.dartsapp.ui.HomeScreen
import com.example.dartsapp.ui.ModeScreen
import com.example.dartsapp.ui.SettingScreen
import com.example.dartsapp.ui.GamePlayScreen

enum class DartScreen() {
    Homepage,
    Mode,
    Setting,
    Gameplay
}

@Composable
fun DartsAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun DartsApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold(
//        modifier = Modifier.fillMaxSize().background(Color.Black),
        topBar = {
            DartsAppBar(
                canNavigateBack = false,
                navigateUp = { /* TODO: implement back navigation */ }
            )
        }
    ) { innerPadding ->


        NavHost(
            navController = navController,
            startDestination = DartScreen.Homepage.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = DartScreen.Homepage.name) {
                HomeScreen(
                    modeOptions = modeOptions,
                    onNextButtonClicked = {
                        navController.navigate(DartScreen.Mode.name)
                    }
                )
            }

            composable(route = DartScreen.Mode.name) {
                ModeScreen(
                    zeroOneModeOptions = zeroOneModeOptions,
                    onNextButtonClicked = {
                        navController.navigate(DartScreen.Setting.name)
                    }
                )
            }
            composable(route = DartScreen.Setting.name) {
                SettingScreen(
                    onGameOnButtonClicked = {
                        navController.navigate(DartScreen.Gameplay.name)
                    }
                )
            }

            composable(route = DartScreen.Gameplay.name) {
                GamePlayScreen()
            }

        }
    }
}





