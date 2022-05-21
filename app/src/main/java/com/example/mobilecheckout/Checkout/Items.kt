package com.example.mobilecheckout.Checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobilecheckout.AddItemViewModel
import com.example.mobilecheckout.ui.theme.LGray
import com.example.mobilecheckout.ui.theme.Navy

@Composable
fun Items(
    //Takes in the List of items
    items:List<Item>,
    onDelete: (Int) -> Unit
){
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
        //Lazy Column used to display the items, sends each item to ItemRow
        LazyColumn(){
            itemsIndexed(items){
                idx,item -> ItemRow(idx = idx, item = item, onDelete)
            }
        }
    }
}