package com.easit.busmaster.ui.user

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun BusProfileScreen(
    onSaveCompleted: () -> Unit = {}
) {

    val timeList = listOf("6:00AM", "7:00AM", "5:00PM", "7:00PM")
    val locationList = listOf("1&2 DCP", "Ilaro", "Ibese", "3&4 DCP", "College")

    var mondayGoingFrom by remember { mutableStateOf("-Select-") }
    var mondayGoingTo by remember { mutableStateOf("-Select-") }
    var mondayGoingTime by remember { mutableStateOf("-Select-") }
    var mondayGoingTimeExpanded by remember { mutableStateOf(false) }
    var mondayGoingFromExpanded by remember { mutableStateOf(false) }
    var mondayGoingToExpanded by remember { mutableStateOf(false) }
    //
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        //
        item {
            Text(
                text = "Monday",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        //
        item {
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state = ScrollState(0)),
            ){
                //
                TripSchedule(
                    tripType = 0,
                    locationList = locationList,
                    timeList = timeList,
                    expandedTime = mondayGoingTimeExpanded,
                    expandedTimeState = {mondayGoingTimeExpanded = it},
                    currentValueTime = mondayGoingTime,
                    currentValueTimeState = {mondayGoingTime=it},
                    expandedFromLocation = mondayGoingFromExpanded,
                    expandedFromLocationState = {mondayGoingFromExpanded=it},
                    currentValueFromLocation = mondayGoingFrom,
                    currentValueFromLocationState = {mondayGoingFrom=it},
                    expandedToLocation = mondayGoingToExpanded,
                    expandedToLocationState = {mondayGoingToExpanded=it},
                    currentValueToLocation = mondayGoingTo,
                    currentValueToLocationState = {mondayGoingTo=it}
                )

                //
                TripSchedule(
                    tripType = 1,
                    locationList = locationList,
                    timeList = timeList,
                    expandedTime = mondayGoingTimeExpanded,
                    expandedTimeState = {mondayGoingTimeExpanded = it},
                    currentValueTime = mondayGoingTime,
                    currentValueTimeState = {mondayGoingTime=it},
                    expandedFromLocation = mondayGoingFromExpanded,
                    expandedFromLocationState = {mondayGoingFromExpanded=it},
                    currentValueFromLocation = mondayGoingFrom,
                    currentValueFromLocationState = {mondayGoingFrom=it},
                    expandedToLocation = mondayGoingToExpanded,
                    expandedToLocationState = {mondayGoingToExpanded=it},
                    currentValueToLocation = mondayGoingTo,
                    currentValueToLocationState = {mondayGoingTo=it}
                )
            }
        }

        item {
            Text(
                text = "Tuesday",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        item {
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state = ScrollState(0)),
            ){
                //
                TripSchedule(
                    tripType = 0,
                    locationList = locationList,
                    timeList = timeList,
                    expandedTime = mondayGoingTimeExpanded,
                    expandedTimeState = {mondayGoingTimeExpanded = it},
                    currentValueTime = mondayGoingTime,
                    currentValueTimeState = {mondayGoingTime=it},
                    expandedFromLocation = mondayGoingFromExpanded,
                    expandedFromLocationState = {mondayGoingFromExpanded=it},
                    currentValueFromLocation = mondayGoingFrom,
                    currentValueFromLocationState = {mondayGoingFrom=it},
                    expandedToLocation = mondayGoingToExpanded,
                    expandedToLocationState = {mondayGoingToExpanded=it},
                    currentValueToLocation = mondayGoingTo,
                    currentValueToLocationState = {mondayGoingTo=it}
                )

                //
                TripSchedule(
                    tripType = 1,
                    locationList = locationList,
                    timeList = timeList,
                    expandedTime = mondayGoingTimeExpanded,
                    expandedTimeState = {mondayGoingTimeExpanded = it},
                    currentValueTime = mondayGoingTime,
                    currentValueTimeState = {mondayGoingTime=it},
                    expandedFromLocation = mondayGoingFromExpanded,
                    expandedFromLocationState = {mondayGoingFromExpanded=it},
                    currentValueFromLocation = mondayGoingFrom,
                    currentValueFromLocationState = {mondayGoingFrom=it},
                    expandedToLocation = mondayGoingToExpanded,
                    expandedToLocationState = {mondayGoingToExpanded=it},
                    currentValueToLocation = mondayGoingTo,
                    currentValueToLocationState = {mondayGoingTo=it}
                )
            }
        }


    }
}

@Composable
fun TripSchedule(
    tripType: Int,//0 for going //1 for return
    locationList: List<String>,
    timeList: List<String>,

    expandedTime: Boolean,
    expandedTimeState: (Boolean) -> Unit,
    currentValueTime: String,
    currentValueTimeState: (String) -> Unit,

    expandedFromLocation: Boolean,
    expandedFromLocationState: (Boolean) -> Unit,
    currentValueFromLocation: String,
    currentValueFromLocationState: (String) -> Unit,

    expandedToLocation: Boolean,
    expandedToLocationState: (Boolean) -> Unit,
    currentValueToLocation: String,
    currentValueToLocationState: (String) -> Unit
) {

    val boxWidth by remember { mutableStateOf(54) }

    //
    Column(
        modifier = Modifier
            .wrapContentWidth()
    ) {
        //
        Text(
            text = if (tripType == 0){"Going"}else{"Returning"},
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            //verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.LightGray)
                .padding(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                //
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "From",
                        modifier = Modifier
                            .width(boxWidth.dp)
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.Gray)
                            .padding(12.dp)
                            .clickable {
                                expandedFromLocationState(!expandedFromLocation)
                            }
                    ) {
                        Text(text = currentValueFromLocation)
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                    }
                    DropdownMenu(expanded = expandedFromLocation, onDismissRequest = {
                        expandedFromLocationState(false)
                    }) {
                        locationList.forEach {
                            DropdownMenuItem(
                                text = { Text(text = it)},
                                onClick = {
                                    currentValueFromLocationState(it)
                                    expandedFromLocationState(false)
                                }
                            )
                        }
                    }
                }
                //
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "To",
                        modifier = Modifier
                            .width(boxWidth.dp)
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.Gray)
                            .padding(12.dp)
                            .clickable {
                                expandedToLocationState(!expandedToLocation)
                            }
                    ) {
                        Text(text = currentValueToLocation)
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                    }
                    DropdownMenu(expanded = expandedToLocation, onDismissRequest = {
                        expandedToLocationState(false)
                    }) {
                        locationList.forEach {
                            DropdownMenuItem(
                                text = { Text(text = it)},
                                onClick = {
                                    currentValueToLocationState(it)
                                    expandedToLocationState(false)
                                }
                            )

                            DropdownMenuItem(
                                text = { Text(text = it)},
                                onClick = {
                                    currentValueToLocationState(it)
                                    expandedToLocationState(false)
                                }
                            )
                        }
                    }
                }
            }
            Column (
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = "Time")
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Gray)
                        .padding(12.dp)
                        .clickable {
                            expandedTimeState(!expandedTime)
                        }
                ) {
                    Text(text = currentValueTime)
                    Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = expandedTime, onDismissRequest = {
                    expandedTimeState(false)
                }) {
                    timeList.forEach {
                        /*DropdownMenuItem(onClick = {
                            currentValueTimeState(it)
                            expandedTimeState(false)
                        }) {
                            Text(text = it)
                        }*/

                        DropdownMenuItem(
                            text = { Text(text = it)},
                            onClick = {
                                currentValueTimeState(it)
                                expandedTimeState(false)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusProfilePreview() {
    BusMasterTheme() {
        BusProfileScreen()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TripSchedulePreview() {
//    val otherList = listOf("abc", "ilaro", "ibese")
//    DMapTheme {
//        TripSchedule(
//            tripType = 0,
//            expanded = true,
//            expandedState = {},
//            currentValue = "Baggy",
//            currentValueState = {},
//            locationList = otherList
//        )
//    }
//}