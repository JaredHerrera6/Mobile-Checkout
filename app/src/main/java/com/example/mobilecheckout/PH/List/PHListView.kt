package com.example.mobilecheckout.PH.List

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mobilecheckout.PH.PHModel

@ExperimentalFoundationApi
@Composable
fun PHListView(
    nav : NavController,
    vm: PHListViewModel = viewModel(),
    albums:List<PHModel>,

    ) {
    Box(
        contentAlignment = Alignment.Center,
    ){
        Column {
            LazyColumn{
                itemsIndexed(albums) {idx, purchase ->
                    PHRow(nav, vm, purchase)
                }
            }
        }
    }
}