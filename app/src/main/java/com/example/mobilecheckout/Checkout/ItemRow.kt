package com.example.mobilecheckout.Checkout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ItemRow(
    idx:Int,
    item: Item,
    onDelete:(Int) -> Unit
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)){
                //Randomly Assigns a item number to an Item
                Text("Item " + (0..30).random() , fontSize = 25.sp)
                Text(item.name, fontSize = 25.sp)
                Text(item.brand)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Price: " + item.price.toString(), fontSize = 30.sp)
                Button(
                    //On clicking theh trashcan Button, it will delete the current Item
                    onClick = { onDelete(idx)},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Icon(Icons.Filled.Delete,null,tint = Color(0xFF3F51B5)
                    )
                }
            }
        }
    }
}