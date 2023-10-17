package com.easit.busmaster

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.easit.busmaster.ui.admin.BusAdminHomeScreen
import com.easit.busmaster.ui.admin.BusAdminSequenceDetailScreen
import com.easit.busmaster.ui.admin.BusAdminSequenceReviewScreen
import com.easit.busmaster.ui.entry.ChoiceScreen
import com.easit.busmaster.ui.entry.forgotPassword.ForgotPasswordConfirmationScreen
import com.easit.busmaster.ui.entry.forgotPassword.ForgotPasswordScreen
import com.easit.busmaster.ui.entry.login.LoginScreen
import com.easit.busmaster.ui.entry.signUp.SignUpScreen
import com.easit.busmaster.ui.user.BusHomeScreen
import com.easit.busmaster.ui.user.BusProfileScreen

sealed class Screen(val route: String) {
    object SignUpScreen : Screen("sign_up")
    object LoginScreen : Screen("login")
    object ForgotPasswordScreen: Screen("forgot_password")
    object ForgotPasswordConfirmationScreen: Screen("forgot_password_confirmation")

    object ChoiceScreen: Screen("choice_screen")

    //
    object BusAdminHomeScreen: Screen("bus_admin_home_screen")
    object BusAdminSequenceDetailScreen: Screen("bus_admin_sequence_detail_screen")
    object BusAdminSequenceReviewScreen: Screen("bus_admin_sequence_review_screen")

    //
    object BusHomeScreen: Screen("bus_home_screen")
    object BusProfileScreen: Screen("bus_profile_screen")


}


@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding : Dp
) {

    NavHost(
        navController = navController,
        startDestination = Screen.ChoiceScreen.route
    ) {
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(
                onSaveCompleted = { navController.navigate(Screen.LoginScreen.route) }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                onSignUpClicked = { navController.navigate(Screen.SignUpScreen.route) },
                onForgotPassword = { navController.navigate(Screen.ForgotPasswordScreen.route) },
                onLoginClicked = { navController.navigate(Screen.ChoiceScreen.route) }
            )
        }
        composable(Screen.ForgotPasswordScreen.route) {
            ForgotPasswordScreen(
                onSaveCompleted = { navController.navigate(Screen.ForgotPasswordConfirmationScreen.route) }
            )
        }
        composable(Screen.ForgotPasswordConfirmationScreen.route) {
            ForgotPasswordConfirmationScreen(
                onSaveCompleted = { navController.navigate(Screen.LoginScreen.route) }
            )
        }

        composable(Screen.ChoiceScreen.route) {
            ChoiceScreen(
                onUserClicked = { navController.navigate(Screen.BusHomeScreen.route) },
                onAdminClick = { navController.navigate(Screen.BusAdminHomeScreen.route) }
            )
        }

        composable(Screen.BusHomeScreen.route) {
            BusHomeScreen(
                onSaveCompleted = { navController.navigate(Screen.ChoiceScreen.route) }
            )
        }

        composable(Screen.BusProfileScreen.route) {
            BusProfileScreen(
                onSaveCompleted = { navController.navigate(Screen.BusHomeScreen.route) }
            )
        }

        composable(Screen.BusAdminHomeScreen.route) {
            BusAdminHomeScreen(
                onSaveCompleted = { navController.navigate(Screen.ChoiceScreen.route) }
            )
        }

        composable(Screen.BusAdminSequenceDetailScreen.route) {
            BusAdminSequenceDetailScreen(
                onSaveCompleted = { navController.navigate(Screen.BusAdminHomeScreen.route) }
            )
        }

        composable(Screen.BusAdminSequenceReviewScreen.route) {
            BusAdminSequenceReviewScreen(
                onSaveCompleted = { navController.navigate(Screen.BusAdminHomeScreen.route) }
            )
        }



    }
}