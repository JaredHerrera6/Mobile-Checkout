package com.example.mobilecheckout

sealed class Screen(val route: String){
    object HScreen: Screen("home_screen")
    object COHome: Screen("Cout_screen")
    object PurHistory : Screen("PHistory_screen")
    object PInfor : Screen("pinfo_screen")
    object Co : Screen("CheckoutItems")
    object AddNewItem: Screen("Add new Items")
    object Pay:Screen("Pay")
    object Scan:Screen("Scan")
}
