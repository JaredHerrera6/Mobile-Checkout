package com.example.mobilecheckout.Checkout

import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobilecheckout.AddItemViewModel
import com.example.mobilecheckout.ui.theme.LGray
import com.example.mobilecheckout.ui.theme.Navy

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddItem (
    vm : AddItemViewModel = viewModel(),
    onAddItem:(Item) -> Unit
){
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
    ){
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "New Item", fontSize = 30.sp)
        }
        //Row to ask for the title
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            //Takes in the name and assigns input to a new Item
            TextField(value = vm.name.value,
                onValueChange = vm::setName,
                label = {
                    Text("Name")
                },
                singleLine = true,
                modifier = Modifier.padding(15.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )
        }
        //TextField for the Contents
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            //Takes in the brand and assigns input to a new Item
            TextField(value = vm.brand.value, onValueChange = vm::setBrand,
                label = {
                    Text("Brand")
                },
                singleLine = false,
                modifier = Modifier.padding(30.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            //Takes in the price and assigns input to a new Item
            TextField(value = vm.price.value, onValueChange = vm::setPrice,
                label = {
                    Text("Price")
                },
                singleLine = false,
                modifier = Modifier.padding(30.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                )
            )
        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp),
        ){
            Button(onClick = {
                try {
                    //Checks to see if all TextFields Have an input
                    val item = vm.validate()
                    //Adds New item with the given inputs
                    onAddItem(item)
                }catch(e:Exception){
                    //Returns a toast msg saying that an input field was left blank
                    Toast.makeText(localC,e.toString(),Toast.LENGTH_SHORT).show()
                }
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF3F51B5))
            ) {
                Text(text = "Add Item", color = Color.White)
            }
        }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(text = "Or", fontSize = 20.sp)
        }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 15.dp)
        ) {
            //Intended to be a button that fires up the scanner option
            //But scanner was not implemented
           Button(onClick = {
               //Returns message that the app cannot scan yet
               Toast.makeText(localC,"Cannot Scan Yet!!",Toast.LENGTH_SHORT).show()
           },
               colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF3F51B5))
           ) {
               Text(text = "Scan Item", color = Color.White)
           }     
        }
    }
}