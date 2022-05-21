package com.example.mobilecheckout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilecheckout.Checkout.*
import com.example.mobilecheckout.PH.List.PHListView
import com.example.mobilecheckout.PH.List.PHListViewModel

import com.example.mobilecheckout.PH.MoreInfo
import com.example.mobilecheckout.PayInfo.PayInfoViewModel



@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun Navigation(
    navController: NavHostController
){
    val addItemvm: AddItemViewModel = viewModel()
    val slvm : SongListVM = viewModel()
    val vm : PHListViewModel= viewModel()
    val PayInfoViewModel: PayInfoViewModel = viewModel()
    NavHost(
        navController = navController ,
        startDestination = Screen.HScreen.route
    ){
        composable(
            route = Screen.HScreen.route
        ){
            MCHome(navController = navController)
        }
        //Sends to the Checkout Home
        composable(
            route = Screen.COHome.route
        ){
            CheckoutHome(slvm,navController)
        }
        //Sends to the Add new Item Composable
        composable(
            route = Screen.AddNewItem.route
        ){
            AddItem(addItemvm,
                onAddItem = { item ->
                    slvm.addItem(item)
                    navController.navigate(Screen.COHome.route)
                })
        }
        //Sends the the checkout Screen
        composable(
            route = Screen.Pay.route
        ){
            PayItems(slvm,navController)
        }
        composable("moreInfo/{more}"){ backStackEntry ->
            val more = backStackEntry.arguments?.getString("more")

            if (more != null) {
                MoreInfo(
                    more
                )
            }
        }
        composable(
            route = Screen.PurHistory.route
        ){
            PHListScreen(navController,vm)
        }
        composable(
            route = Screen.PInfor.route
        ){


            PaymentInfo(navController, PayInfoViewModel, onAddPayInfo = { payInfo -> PayInfoViewModel.addPayInfo(payInfo) })

        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PHListScreen (
    nav : NavController,
    vm: PHListViewModel,
) {
    val purchases by vm.purchases

    PHListView(
        nav,
        vm,
        purchases,

    )
}

