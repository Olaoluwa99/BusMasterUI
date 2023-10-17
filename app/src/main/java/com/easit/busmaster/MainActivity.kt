package com.easit.busmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.easit.busmaster.ui.theme.BusMasterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusMasterTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val showTopAppBer = remember { mutableStateOf(true) }

                fun getRoute(): Screen{
                    return when(backStackEntry?.destination?.route){
                        Screen.SignUpScreen.route -> Screen.SignUpScreen
                        Screen.LoginScreen.route -> Screen.LoginScreen
                        Screen.ForgotPasswordScreen.route -> Screen.ForgotPasswordScreen
                        Screen.ForgotPasswordConfirmationScreen.route -> Screen.ForgotPasswordConfirmationScreen
                        Screen.ChoiceScreen.route -> Screen.ChoiceScreen
                        Screen.BusHomeScreen.route -> Screen.BusHomeScreen
                        Screen.BusProfileScreen.route -> Screen.BusProfileScreen
                        Screen.BusAdminHomeScreen.route -> Screen.BusAdminHomeScreen
                        Screen.BusAdminSequenceDetailScreen.route -> Screen.BusAdminSequenceDetailScreen
                        Screen.BusAdminSequenceReviewScreen.route -> Screen.BusAdminSequenceReviewScreen
                        else -> Screen.ChoiceScreen
                    }
                }

                val currentScreen = getRoute()
                //val mainViewModel = viewModel<MainViewModel>()

                when (backStackEntry?.destination?.route){
                    Screen.SignUpScreen.route -> showTopAppBer.value = false
                    Screen.LoginScreen.route -> showTopAppBer.value = false
                    Screen.ForgotPasswordScreen.route -> showTopAppBer.value = false
                    Screen.ForgotPasswordConfirmationScreen.route -> showTopAppBer.value = false
                    else -> showTopAppBer.value = true
                }

                //TODO
                Scaffold(
                    topBar = {
                        when (showTopAppBer.value) {
                            true -> {
                                PageAppBar(
                                    username = "Olaoluwa99",
                                    navController = navController,
                                    currentScreen = currentScreen,
                                    canNavigateBack = navController.previousBackStackEntry != null,
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            else -> {
                                //  Show nothing
                            }
                        }
                    }
                ) {
                    Navigation(navController = navController, innerPadding = it.calculateTopPadding())
                }
            }
        }
    }
}
