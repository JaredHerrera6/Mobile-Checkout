package com.example.mobilecheckout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobilecheckout.ui.theme.LGray
import com.example.mobilecheckout.ui.theme.MobileCheckoutTheme
import com.example.mobilecheckout.ui.theme.Navy

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    @OptIn(ExperimentalComposeUiApi::class,
        androidx.compose.foundation.ExperimentalFoundationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileCheckoutTheme {
                navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}
@Composable
fun MCHome(navController: NavController) {
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
        ){
            Text(text = "Mobile Checkout"
                , fontSize = 35.sp)
            Text(text = "Home Screen"
                , fontSize = 30.sp)
            // Same image as the app icon
            Image(
                painterResource(R.mipmap.ic_launcher_foreground),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            // This button will direct to the Start Checkout Page
            Button(
                // Navigate to the Checkout Home Page
                onClick = {
                    navController.navigate(route = Screen.COHome.route)
                },
                modifier = Modifier.padding(top = 25.dp),// gives 35.dp space between SC and HomeScreen
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White
                )
            //Content inside the The checkout Button row
            ){
                Image(
                    painterResource(R.drawable.scansymbol_foreground), // Scanning Image
                    contentDescription = "" ,
                    contentScale = ContentScale.Crop
                )
                Text(text = "Start Checkout")
            }
            // This button Will direct to the Purchase History page
            Button(
                // Navigates to the Purchase History Screen
                onClick = {
                          navController.navigate(route = Screen.PurHistory.route)
                },
                modifier = Modifier.padding(top = 35.dp), // Gives a Space between history and SC
                colors = ButtonDefaults.buttonColors( // History Image
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White
                )
            // Content Inside the Purchase History Button Row
            ){
                Image(
                    painterResource(R.drawable.purchasehistory_foreground), // Scanning Image
                    contentDescription = "" ,
                    contentScale = ContentScale.Crop
                )
                Text(text = "Purchase History")
            }
            // This button will direct to the Payment Information page
            Button(
                //Navigates to the Payment information Screen
                onClick = {
                          navController.navigate(route = Screen.PInfor.route)
                },
                modifier = Modifier.padding(35.dp), // Gives space between PurchaseH and history bttn
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White
                )
            // Content inside the Payment Information Button Row
            ){
                // Scanning Image
                Image(
                    painterResource(R.drawable.payinfo_foreground),
                    contentDescription = "" ,
                    contentScale = ContentScale.Crop
                )
                Text(text = "Payment Information")
            }
        }
}
@Composable
@Preview(showBackground = true)
fun MCHomePreview(){
    MCHome(
        navController = rememberNavController()
    )
}


