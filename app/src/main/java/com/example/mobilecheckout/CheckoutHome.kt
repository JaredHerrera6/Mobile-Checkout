package com.example.mobilecheckout

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobilecheckout.Checkout.Item
import com.example.mobilecheckout.Checkout.Items
import com.example.mobilecheckout.Checkout.SongListVM
import com.example.mobilecheckout.ui.theme.LGray
import com.example.mobilecheckout.ui.theme.Navy
import org.intellij.lang.annotations.JdkConstants
import java.text.DecimalFormat
import kotlin.math.roundToInt

@Composable
fun CheckoutHome(vm: SongListVM, navController: NavController) {
    val items by vm.items
    //Scaffold is created for add item button
    // and also the checkout nav button
    Scaffold (
        bottomBar = { BottomBar(navController,items)},
        floatingActionButton = {FAB(navController)}
    ){
        Column(
            modifier  = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(LGray, Navy)
                    )
                )
        ){
            Text(
                text = "Checkout Home",
                fontSize = 20.sp,

                )
            //Sends the items and also the Delete item function to Items Composable
            Items(items,vm::deleteItem)
        }
    }

}

@Composable
fun BottomBar(navController: NavController,items: List<Item>){
    val backStateEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStateEntry.value?.destination
    BottomAppBar {
        Button(
            //When clicking the Checkout Button, will be directed to the Paying Page
            onClick = { navController.navigate(Screen.Pay.route){
                launchSingleTop = true
            } },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF009688))
        ) {
            //Gets the prices from the items List
            val priceList = items.map{item ->
                item.price.toDouble()
            }
            //Decimal Format to display the price amount
            val df = DecimalFormat("##.00")
            //Adds the prices stored in the List
            val total = priceList.sum()
            val roundoff = df.format(total)
            Text(text = "Checkout :$", color = Color.White)
            //Displays the Total Next to the Checkout Button
            Text(text = roundoff.toString(), color = Color.White)
        }
    }
}
@Composable
fun FAB(navController: NavController){
    val backStateEntry = navController.currentBackStackEntryAsState()
    FloatingActionButton(
        ////When you click nav controller is call and goes to the Add new screen
        onClick = {navController.navigate(Screen.AddNewItem.route){
            launchSingleTop = true
        } },
        backgroundColor = Color(0xFF3F51B5),
        contentColor =  Color.White,

        ){
        Icon(Icons.Filled.Add, null)
    }
}
// Composabale Screen To View total Price, items , and Purchase
@Composable
fun PayItems(vm: SongListVM,nav:NavController){
    val items by vm.items
    //Gets the prices from the items List
    val priceList = items.map{item ->
        item.price.toDouble()
    }
    //Decimal Format to display the price amount
    val df = DecimalFormat("##.00")
    //Adds the prices stored in the List
    val total = priceList.sum()
    val roundoff = df.format(total)
    //Gets the total numbers of items in teh list or Cart
    val itemsNum = priceList.size
    val localC = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(LGray, Navy)
                )
            )
    ) {
        Row(horizontalArrangement = Arrangement.Center){
            Text(text = "MOBILE CHECKOUT"
                , fontSize = 35.sp, modifier = Modifier.padding(bottom = 50.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.Center) {
            //Displays the total number of items
            Text(text = "Total Items: $itemsNum",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp))
        }
        Row(horizontalArrangement = Arrangement.Center) {
            //Displays the Total Price
            Text(text = "Item Total:$ $roundoff",
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp))
        }
        Button(onClick = {
            Toast.makeText(localC,"Checkout Complete", Toast.LENGTH_SHORT).show()
        }
            ,
            modifier = Modifier.padding(bottom = 20.dp)
            ) {
            Text(text = "Complete Checkout")
        }
    }
}

