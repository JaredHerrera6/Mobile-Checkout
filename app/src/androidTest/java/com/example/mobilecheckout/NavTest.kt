package com.example.mobilecheckout

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.services.events.TestCaseInfo
import com.example.mobilecheckout.Checkout.AddItem
import com.example.mobilecheckout.Checkout.SongListVM
import com.example.mobilecheckout.PayInfo.PayInfoViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavTest {
    private lateinit var vm : SongListVM
    private lateinit var nav : TestNavHostController
    private lateinit var avm : AddItemViewModel
    private lateinit var  PayInfoViewModel: PayInfoViewModel
    @get:Rule
    val testRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        nav = TestNavHostController(ApplicationProvider.getApplicationContext())
    }
    @Test
    fun mcHome(){
        testRule.setContent{
            MCHome(nav)
        }
        testRule.onNodeWithText("Mobile Checkout")
            .assertIsDisplayed()
    }

    @Test
    fun coHome(){
        testRule.setContent {
            CheckoutHome(vm = viewModel(), nav )
        }
        testRule.onNodeWithText("Checkout Home")
            .assertIsDisplayed()
    }
    @Test
    fun addIt(){
        testRule.setContent {
            AddItem(vm = viewModel() ,onAddItem = { item ->
                vm.addItem(item)
                nav.navigate(Screen.COHome.route)
            })
        }
        testRule.onNodeWithText("New Item")
            .assertIsDisplayed()
    }
    @Test
    fun payIt(){
        testRule.setContent {
            PayItems(vm = viewModel(), nav =nav )
        }
        testRule.onNodeWithText("MOBILE CHECKOUT")
            .assertIsDisplayed()
    }
    @Test
    fun pInfo(){
        testRule.setContent {
            PaymentInfo(navController = nav,PayInfoViewModel,{ payInfo -> PayInfoViewModel.addPayInfo(payInfo) })
        }
        testRule.onNodeWithText("Name on Card")
            .assertIsDisplayed()
    }
}