package com.easit.busmaster.ui.entry.signUp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.ui.theme.BusMasterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    onSaveCompleted: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("" ) }
    var password by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(state = ScrollState(0)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Icon(
            Icons.Filled.LocationOn,
            //tint = Color.White,
            "Location",
            modifier = Modifier
                .height(75.dp)
                .width(75.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                .clickable {
                    //
                }
                .padding(24.dp)
        )
        Spacer(modifier = Modifier.height(45.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it},
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            singleLine = true,
            label = {Text(text = "Username")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
            )
        )

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
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
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
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp))
                .background(Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                .clickable { /* */ }
                .padding(16.dp),
        ) {
            Text(text = "Submit")
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
                .clickable { }
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
            Text(text = "Github", color = Color.White)
        }
    }
}

//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    BusMasterTheme() {
        SignUpScreen()
    }
}