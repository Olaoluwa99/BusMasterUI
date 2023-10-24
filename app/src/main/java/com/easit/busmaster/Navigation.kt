package com.easit.busmaster

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
    object SignUpScreen : Screen("Sign-up")
    object LoginScreen : Screen("Login")
    object ForgotPasswordScreen: Screen("Forgot password")
    object ForgotPasswordConfirmationScreen: Screen("Forgot password confirmation")

    object ChoiceScreen: Screen("Choice screen")

    //
    object BusAdminHomeScreen: Screen("All trips")
    object BusAdminSequenceDetailScreen: Screen("Bus detail")
    object BusAdminSequenceReviewScreen: Screen("Sequence review")

    //
    object BusHomeScreen: Screen("My trips")
    object BusProfileScreen: Screen("My profile")

    fun withArgs (vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}


@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding : Dp
) {

    val choiceId = remember { mutableStateOf("") }
    NavHost(
        navController = navController,
        startDestination = Screen.ChoiceScreen.route
    ) {
        composable(
            route = Screen.LoginScreen.route + "/{choiceId}",
            arguments = listOf(
                navArgument("choiceId") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            LoginScreen(
                choiceId = entry.arguments?.getString("choiceId"),
                onSignUpClicked = { navController.navigate(Screen.SignUpScreen.route) },
                onForgotPassword = { navController.navigate(Screen.ForgotPasswordScreen.route) },
                onUserLoginClicked = { navController.navigate(Screen.BusHomeScreen.route) },
                onAdminLoginClicked = { navController.navigate(Screen.BusAdminHomeScreen.route) }
            )
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(
                onSaveCompleted = { navController.popBackStack() }
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
                onChoiceClicked = {
                    choiceId.value = it
                    navController.navigate(Screen.LoginScreen.withArgs(choiceId.value))
                }
            )
        }

        composable(Screen.BusHomeScreen.route) {
            BusHomeScreen(
                onTripClicked = { navController.navigate(Screen.BusProfileScreen.route) }
            )
        }

        composable(Screen.BusProfileScreen.route) {
            BusProfileScreen(
                onSaveCompleted = { navController.navigate(Screen.BusHomeScreen.route) }
            )
        }

        composable(Screen.BusAdminHomeScreen.route) {
            BusAdminHomeScreen(
                onSaveCompleted = { navController.navigate(Screen.BusAdminSequenceDetailScreen.route) }
            )
        }

        composable(Screen.BusAdminSequenceDetailScreen.route) {
            BusAdminSequenceDetailScreen(
                onSaveCompleted = { navController.navigate(Screen.BusAdminSequenceReviewScreen.route) }
            )
        }

        composable(Screen.BusAdminSequenceReviewScreen.route) {
            BusAdminSequenceReviewScreen(
                onSaveCompleted = { navController.popBackStack(Screen.BusAdminHomeScreen.route, false) }
            )
        }
    }
}