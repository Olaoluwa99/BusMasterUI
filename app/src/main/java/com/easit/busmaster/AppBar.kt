package com.easit.busmaster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageAppBar(
    username: String,
    navController: NavHostController,
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (navController.currentDestination?.route) {
        Screen.ChoiceScreen.route -> {
            //No topBar
        }

        Screen.BusHomeScreen.route,
        Screen.BusAdminHomeScreen.route -> {
            TopAppBar (
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = stringResource(R.string.back_button)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = currentScreen.route,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 24.sp
                                )
                            }

                            //
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.MoreVert,
                                    contentDescription = stringResource(R.string.menu_button)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
                        ){
                            //
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                                    .background(
                                        Color(
                                            red = 0.96f,
                                            green = 0.69f,
                                            0.31f,
                                            alpha = 1f
                                        )
                                    )
                            )
                        }
                    }
                }
            )
        }

        Screen.BusProfileScreen.route,
        Screen.BusAdminSequenceDetailScreen.route,
        Screen.BusAdminSequenceReviewScreen.route-> {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Row(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = stringResource(R.string.back_button)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = currentScreen.route,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 24.sp
                                )
                            }

                            //
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.MoreVert,
                                    contentDescription = stringResource(R.string.menu_button)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 0.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
                        ){
                            //
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                                    .background(
                                        Color(
                                            red = 0.96f,
                                            green = 0.69f,
                                            0.31f,
                                            alpha = 1f
                                        )
                                    )
                            )
                        }
                    }
                }
            )
        }

        Screen.SignUpScreen.route,
        Screen.LoginScreen.route,
        Screen.ForgotPasswordScreen.route,
        Screen.ForgotPasswordConfirmationScreen.route-> {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //
                    Row(
                        modifier = Modifier
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = currentScreen.route,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 24.sp
                        )
                    }

                    //
                    Row(
                        modifier = Modifier
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = stringResource(R.string.menu_button)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                //
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
                ){
                    //
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(
                                Color(
                                    red = 0.96f,
                                    green = 0.69f,
                                    0.31f,
                                    alpha = 1f
                                )
                            )
                    )
                }
            }
        }
    }
}
