package com.easit.busmaster.ui.user

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun BusHomeScreen(
    onTripClicked: () -> Unit = {}
) {

    //Pseudo list
    class PseudoList(
        val name: String, val number: String
    )
    val bus1 = PseudoList("Artemis", "48")
    val bus2 = PseudoList("Betta", "42")
    val bus3 = PseudoList("Gamma", "54")
    val bus4 = PseudoList("Delta", "78")
    val bus5 = PseudoList("Infinix", "36")
    val bus6 = PseudoList("Every", "21")
    val fakeBusList = listOf(bus1, bus2, bus3, bus4, bus5, bus6)

    //
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        //
        item{
            Text("BusHome", fontSize = 24.sp)
        }

        //
        item{
            Text("My Trip",fontWeight = FontWeight.Bold)
        }

        item {
            //
            Text(text = "Going trip")
            BusTicketType(
                busName = fakeBusList[0].name,
                tripTime = "09:00AM",
                entryLocation = "1&2 DCP gate",
                exitLocation = "Arolat, Ibese",
                onTripClicked = onTripClicked

            )
        }

        item {
            //
            Text(text = "Return trip")
            BusTicketType(
                busName = fakeBusList[2].name,
                tripTime = "07:00PM",
                entryLocation = "3&4 DCP gate",
                exitLocation = "New Garage, Ilaro",
                onTripClicked = onTripClicked
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .clickable { /**/ }
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No bus reservation available",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }

        item{
            Text("Available buses",fontWeight = FontWeight.Bold)
        }

//        items(count = fakeBusList.size){
//            BusDetailList(fakeBusList[it].name, fakeBusList[it].number)
//        }

        items(count = fakeBusList.size){
            BusDetailList2(
                fakeBusList[it].name,
                fakeBusList[it].number,
                "In transit from Plant to Ilaro"
            )
        }

    }
}

@Composable
fun BusDetailList(
    busName: String,
    seatNumber: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = busName)
        Text(
            text = seatNumber,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BusDetailList2(
    busName: String,
    seatNumber: String,
    status: String
) {
    //
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .clickable { /**/ }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(4f)
        ) {
            Text(
                text = busName,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = status)
        }
        Text(
            text = seatNumber,
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray)
                .clickable {
                    //
                }
                .padding(12.dp)
            ,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BusTicketType(
    busName: String,
    tripTime: String,
    entryLocation: String,
    exitLocation: String,
    onTripClicked: () -> Unit = {}
) {
    //
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .clickable { onTripClicked() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(7f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "Bus name: $busName",
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Entry: $entryLocation",
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Exit: $exitLocation",
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            modifier = Modifier
                .weight(3f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = tripTime,
                modifier = Modifier
                    .width(160.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Gray)
                    .padding(12.dp)
                ,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Cancel",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(160.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Red)
                    .clickable {
                        //
                    }
                    .padding(12.dp)
                ,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BusHomePreview() {
    BusMasterTheme() {
        BusHomeScreen()
    }

}