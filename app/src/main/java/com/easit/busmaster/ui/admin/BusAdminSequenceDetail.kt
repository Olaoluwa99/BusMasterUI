package com.easit.busmaster.ui.admin

import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.ui.theme.BusMasterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusAdminSequenceDetailScreen(
    onSaveCompleted: () -> Unit = {}
) {
    //
    val pseudoList = listOf("Dutch", "Sawyer", "Internal", "Inertia", "Callus")
    var checked by remember { mutableStateOf(true) }
    var searchText by remember { mutableStateOf("") }

    //
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        //
        item {
            Spacer(modifier = Modifier.height(48.dp))
        }

        item {
            Text(
                text = "Select available buses",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        //
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it},
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight(),
                    singleLine = true,
                    label = {Text(text = "Search bus")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
                    )
                )

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    Icons.Default.Search,
                    //tint = Color.White,
                    "Search",
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                        .clickable {
                            //
                        }
                        .padding(12.dp)
                )
            }
        }

        items(count = pseudoList.size){
            //checked = !checked
            AvailableBus (
                pseudoList[it],
                checked = checked
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
                    .background(Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                    .clickable { onSaveCompleted() }
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
    checked: Boolean,
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
            checked = checked,
            onCheckedChange = { busAvailable(busName) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
            )
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