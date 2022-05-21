package com.example.mobilecheckout.PH

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@ExperimentalFoundationApi
@Composable
fun MoreInfo(
  MoreI: String
){
//takes the info sent from the on click action from the list and splits it apart to be shown on the page
    val lim = "@"
    val more = MoreI.split(lim)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = more.elementAt(0),
            fontSize = 40.sp,
            modifier = Modifier
                .padding(40.dp)
        )


        AsyncImage(
            modifier = Modifier.size(200.dp),
            model = more.elementAt(1),
            contentDescription = null
        )

        Text(
            text = "Price: $" + more.elementAt(3),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
        )
        Text(
            text = "Item Description: " + more.elementAt(2),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
        )
    }

}