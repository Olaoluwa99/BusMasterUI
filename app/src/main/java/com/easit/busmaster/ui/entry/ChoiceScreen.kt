package com.easit.busmaster.ui.entry

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easit.busmaster.ui.theme.BusMasterTheme
import com.easit.busmaster.ui.user.BusHomeScreen

@Composable
fun ChoiceScreen(
    onUserClicked: () -> Unit = {},
    onAdminClick: () -> Unit = {}
) {
    //
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        //

    }
}

@Preview(showBackground = true)
@Composable
fun ChoicePreview() {
    BusMasterTheme() {
        BusHomeScreen()
    }

}