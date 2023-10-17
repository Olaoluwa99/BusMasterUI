package com.easit.busmaster.ui.admin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun BusAdminSequenceDetailScreen(
    onSaveCompleted: () -> Unit = {}
) {
    //
    val pseudoList = listOf("Dutch", "Sawyer", "Internal", "Inertia", "Callus")
    //
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        //
        item {
            Text("BusAdminSequenceDetail", fontSize = 24.sp)
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                Icon(
                    Icons.Default.ThumbUp,
                    //tint = Color.White,
                    "Enter",
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Gray)
                        .clickable {

                        }
                        .padding(12.dp)
                )
            }
        }

        item {
            Text(
                text = "Selected available buses",
                fontWeight = FontWeight.Bold,
            )
        }

        items(count = pseudoList.size){
            AvailableBus (
                pseudoList[it]
            ) {
                Log.i("Martin", it)
            }
        }

        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.LightGray)
                    .clickable { /**/ }
                    .padding(16.dp),
            ) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
fun AvailableBus(
    busName: String,
    busAvailable: (String) -> Unit
) {

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ){
        //
        Text(text = busName, fontWeight = FontWeight.Bold)
        Checkbox(
            checked = false,
            onCheckedChange = { busAvailable(busName) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusAdminSequenceDetailPreview() {
    BusMasterTheme() {
        BusAdminSequenceDetailScreen()
    }

}