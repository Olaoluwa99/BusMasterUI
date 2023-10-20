package com.easit.busmaster.ui.entry.login

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.ui.theme.BusMasterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    choiceId: String?,
    onSignUpClicked: () -> Unit = {},
    onForgotPassword: () -> Unit = {},
    onUserLoginClicked: () -> Unit = {},
    onAdminLoginClicked: () -> Unit = {}

) {
    //
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(state = ScrollState(0)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = "$choiceId Login",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .wrapContentWidth()
        )

        Icon(
            Icons.Filled.LocationOn,
            //tint = Color.White,
            "Location",
            modifier = Modifier
                .height(75.dp).width(75.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray)
                .clickable {
                    //
                }
                .padding(24.dp)
        )
        Spacer(modifier = Modifier.height(45.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            singleLine = true,
            label = {Text(text = "Email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            singleLine = true,
            label = {Text(text = "Password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = { onSignUpClicked() },
            ) {
                Text(
                    text = "Sign Up",fontSize = 18.sp,
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                    //modifier = Modifier.lin
                )
            }
            TextButton(
                onClick = { onForgotPassword() },
            ) {
                Text(
                    text = "Forgot password",fontSize = 18.sp,
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp))
                .background(Color.Gray)
                .clickable {
                    /* */
                    if (choiceId == "Admin"){
                        onAdminLoginClicked()
                    }else{
                        onUserLoginClicked()
                    }
                }
                .padding(16.dp),
        ) {

            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(36.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray)
                .clickable { }
                .padding(16.dp),
        ) {
            Text(text = "Google", color = Color.White)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Blue)
                .clickable { onAdminLoginClicked() }
                .padding(16.dp),
        ) {
            Text(text = "Facebook", color = Color.White)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Black)
                .clickable { }
                .padding(16.dp),
        ) {
            Text(text = "Apple", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BusMasterTheme() {
        LoginScreen(choiceId = "Staff")
    }
}