package com.easit.busmaster.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.ui.theme.BusMasterTheme

@Composable
fun BusAdminSequenceReviewScreen(
    onSaveCompleted: () -> Unit = {}
) {
    //
    //Shows scanner for each bus-stop
    //Click checkmark once the bus goes

    val expectedMembersCount by remember { mutableStateOf("00")}
    val scannedMembersCount by remember { mutableStateOf("00")}

    //Pseudo list
    class PseudoList(
        val name: String, val state: String
    )
    val bus1 = PseudoList("Haller", "At the park")
    val bus2 = PseudoList("Betta", "Currently loading")
    val bus3 = PseudoList("Gamma", "In transit")
    val bus4 = PseudoList("Delta", "Reached destination")
    val fakeState = listOf(bus1, bus2, bus3, bus4)

    var expanded by remember { mutableStateOf(false)}
    var selectedBus by remember { mutableStateOf("-Select bus-")}


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        //
        item {
            Text("1&2", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        //
        item {
            //
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Selected bus:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .wrapContentWidth()
                )
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Gray)
                        .padding(12.dp)
                        .clickable {
                            expanded = !expanded
                        }
                ) {
                    Text(text = selectedBus)
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = !expanded
                }) {
                    fakeState.forEach {
                        /*DropdownMenuItem(onClick = {
                            selectedBus = it.name
                            expanded = !expanded
                        }) {
                            Text(text = it.name)
                        }*/
                        DropdownMenuItem(
                            text = { Text(text = it.name)},
                            onClick = {
                                selectedBus = it.name
                                expanded = !expanded
                            }
                        )
                    }
                }
            }
        }

        //
        item {
            Box(modifier =
            Modifier
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Box(modifier =
                Modifier
                    .width(240.dp)
                    .height(240.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.LightGray)
                    .clickable { /**/ }
                    .padding(16.dp)
                )
            }

        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.LightGray)
                    .clickable { /**/ }
                    .padding(16.dp)
            ) {
                Text(text = "Expected members count", fontWeight = FontWeight.Bold)
                Text(
                    text = expectedMembersCount,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.LightGray)
                    .clickable { /**/ }
                    .padding(16.dp)
            ) {
                Text(text = "Scanned members count", fontWeight = FontWeight.Bold)
                Text(
                    text = scannedMembersCount,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.LightGray)
                    .clickable { onSaveCompleted() }
                    .padding(16.dp),
            ) {
                Text(text = "Bus depart")
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Bus status", fontWeight = FontWeight.Bold)
        }

        items(count = fakeState.size){
            BusState (
                fakeState[it].name,
                fakeState[it].state
            )
        }

    }
}

@Composable
fun BusState(
    busName: String,
    busState: String
) {

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ){
        //
        Text(text = busName, fontWeight = FontWeight.Bold)
        Text(
            text = busState,
            modifier = Modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray)
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusAdminSequenceReviewPreview() {
    BusMasterTheme() {
        BusAdminSequenceReviewScreen()
    }

}