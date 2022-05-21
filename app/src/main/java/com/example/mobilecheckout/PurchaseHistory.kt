package com.example.mobilecheckout

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecheckout.ui.theme.LGray
import com.example.mobilecheckout.ui.theme.Navy

@Composable
fun PurchaseHistory(navController: NavController) {

    // Primary Column attribute for the whole HomeScreen page
    Column(
        modifier  = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(LGray, Navy)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Purchase History"
            , fontSize = 30.sp)

        // This button Will direct to the Purchase History page
        Button(
            // Navigates to the Purchase History Screen
            onClick = {
                navController.navigate(route = Screen.PurHistory.route)
            },
            modifier = Modifier.padding(top = 35.dp), // Gives a Space between history and SC
            colors = ButtonDefaults.buttonColors( // History Image
                backgroundColor = androidx.compose.ui.graphics.Color.DarkGray,
                contentColor = androidx.compose.ui.graphics.Color.White
            )
            // Content Inside the Purchase History Button Row
        ){
            Image(
                painterResource(R.drawable.purchasehistory_foreground), // Scanning Image
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )
            Text(text = "Past Purchase")
        }
        Button(
            // Navigates to the Purchase History Screen
            onClick = {
                navController.navigate(route = Screen.PurHistory.route)
            },
            modifier = Modifier.padding(top = 35.dp), // Gives a Space between history and SC
            colors = ButtonDefaults.buttonColors( // History Image
                backgroundColor = androidx.compose.ui.graphics.Color.DarkGray,
                contentColor = androidx.compose.ui.graphics.Color.White
            )
            // Content Inside the Purchase History Button Row
        ){
            Image(
                painterResource(R.drawable.purchasehistory_foreground), // Scanning Image
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )
            Text(text = "Past Purchase")
        }
        Button(
            // Navigates to the Purchase History Screen
            onClick = {
                navController.navigate(route = Screen.PurHistory.route)
            },
            modifier = Modifier.padding(top = 35.dp), // Gives a Space between history and SC
            colors = ButtonDefaults.buttonColors( // History Image
                backgroundColor = androidx.compose.ui.graphics.Color.DarkGray,
                contentColor = androidx.compose.ui.graphics.Color.White
            )
            // Content Inside the Purchase History Button Row
        ){
            Image(
                painterResource(R.drawable.purchasehistory_foreground), // Scanning Image
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )
            Text(text = "Past Purchase")
        }
        Button(
            // Navigates to the Purchase History Screen
            onClick = {
                navController.navigate(route = Screen.PurHistory.route)
            },
            modifier = Modifier.padding(top = 35.dp), // Gives a Space between history and SC
            colors = ButtonDefaults.buttonColors( // History Image
                backgroundColor = androidx.compose.ui.graphics.Color.DarkGray,
                contentColor = androidx.compose.ui.graphics.Color.White
            )
            // Content Inside the Purchase History Button Row
        ){
            Image(
                painterResource(R.drawable.purchasehistory_foreground), // Scanning Image
                contentDescription = "" ,
                contentScale = ContentScale.Crop
            )
            Text(text = "Past Purchase")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun PurchaseHistoryPreview(){
    PurchaseHistory(
        navController = rememberNavController()
    )
}