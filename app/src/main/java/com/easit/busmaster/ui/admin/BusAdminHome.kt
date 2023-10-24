package com.easit.busmaster.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.ui.theme.BusMasterTheme

@Composable
fun BusAdminHomeScreen(
    onSaveCompleted: () -> Unit = {}
) {

    val ibeseText by remember { mutableStateOf("Ibese") }
    val ilaroText by remember { mutableStateOf("Ilaro") }
    val dCP12Text by remember { mutableStateOf("DCP 1&2") }
    val dCP34Text by remember { mutableStateOf("DCP 3&4") }


    //
    //Show Sequence History button
    //It shows by day all bus sequences
    //Open review button

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        //
        Spacer(modifier = Modifier.height(48.dp))

        //
        Text(text = "6: 00AM", fontWeight = FontWeight.Bold)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.LightGray)
                .clickable { onSaveCompleted() }
                .padding(16.dp)
        ) {
            //
            Row() {
                Text(text = "From: ", fontWeight = FontWeight.Bold)
                Text(text = dCP12Text)
            }

            Row() {
                Text(text = "To: ", fontWeight = FontWeight.Bold)
                Text(text = ilaroText)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.LightGray)
                .clickable { /**/ }
                .padding(16.dp)
        ) {
            //
            Row() {
                Text(text = "From: ", fontWeight = FontWeight.Bold)
                Text(text = ilaroText)
            }

            Row() {
                Text(text = "To: ", fontWeight = FontWeight.Bold)
                Text(text = dCP12Text)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //
        Text(text = "5: 00PM", fontWeight = FontWeight.Bold)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.LightGray)
                .clickable { /**/ }
                .padding(16.dp)
        ) {
            //
            Row() {
                Text(text = "From: ", fontWeight = FontWeight.Bold)
                Text(text = dCP12Text)
            }

            Row() {
                Text(text = "To: ", fontWeight = FontWeight.Bold)
                Text(text = ilaroText)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.LightGray)
                .clickable { /**/ }
                .padding(16.dp)
        ) {
            //
            Row() {
                Text(text = "From: ", fontWeight = FontWeight.Bold)
                Text(text = ilaroText)
            }

            Row() {
                Text(text = "To: ", fontWeight = FontWeight.Bold)
                Text(text = dCP12Text)
            }
        }


        //
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                .clickable { /**/ }
                .padding(16.dp),
        ) {
            Text(text = "Show History")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusAdminHomePreview() {
    BusMasterTheme() {
        BusAdminHomeScreen()
    }

}