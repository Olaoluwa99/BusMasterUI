package com.easit.busmaster.ui.entry

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easit.busmaster.R
import com.easit.busmaster.ui.theme.BusMasterTheme
import com.easit.busmaster.ui.user.BusHomeScreen

@Composable
fun ChoiceScreen(
    onChoiceClicked: (String) -> Unit = {}
) {

    val userText by remember { mutableStateOf("User") }
    val adminText by remember { mutableStateOf("Admin") }

    //
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //
        Image(
            painterResource(id = R.drawable.bus1),
            contentDescription = "Bus image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        )//F44B04E

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            //
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                //
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                        .padding(start = 36.dp, end = 36.dp, top = 12.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = "Select a mode",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                //
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(15.dp))
                            .clickable {
                                //
                                onChoiceClicked(userText)
                            },
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(15.dp))
                                .background(brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(red = 0.91f, green = 0.48f, 0.09f, alpha = 1f),
                                        Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
                                    )
                                ))
                                //.background(color = Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f))
                                .clickable {
                                    onChoiceClicked(userText)
                                }
                                .padding(16.dp),
                        ) {
                            Image(
                                painterResource(id = R.drawable.baseline_account_circle_24),
                                contentDescription = "User",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = userText,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    //
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(15.dp))
                            .clickable {
                                //
                                onChoiceClicked(adminText)
                            },
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(15.dp))
                                .background(brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(red = 0.91f, green = 0.48f, 0.09f, alpha = 1f),
                                        Color(red = 0.96f, green = 0.69f, 0.31f, alpha = 1f)
                                    )
                                ))
                                .clickable {
                                    onChoiceClicked(adminText)
                                }
                                .padding(16.dp),
                        ) {
                            Image(
                                painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                                contentDescription = "User",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = adminText,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChoicePreview() {
    BusMasterTheme() {
        ChoiceScreen()
    }

}