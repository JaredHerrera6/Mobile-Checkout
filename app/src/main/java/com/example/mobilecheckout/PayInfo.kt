package com.example.mobilecheckout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilecheckout.PayInfo.PayInfo
import com.example.mobilecheckout.PayInfo.PayInfoViewModel
import java.lang.Exception

@Composable
fun PaymentInfo(
    navController: NavController,
    vm: PayInfoViewModel = viewModel(),
    onAddPayInfo: (PayInfo) -> Unit
) {

//    var name by remember { mutableStateOf("") }
//    var cardNum by remember { mutableStateOf("") }
//    var expirationMonth by remember { mutableStateOf("") }
//    var expirationYear by remember { mutableStateOf("") }
//    var address by remember { mutableStateOf("") }

//    var country by remember { mutableStateOf("") }
//    var securityCode by remember { mutableStateOf("") }
//    var zipcode by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.padding(all = 4.dp)
    ) {
        Text(text = "Name on Card")
        TextField(
            value = vm.name.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setName(value) },
//                onValueChange = vm::setName,
            placeholder = { Text(text = "Name on Card")}
        )
        Text(text = "Card Number")
        TextField(
            value = vm.cardNum.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setCardNum(value) },
//                onValueChange = vm::setCardNum,
            placeholder = { Text(text = "0000 0000 0000 0000")}
        )
        Text(text = "CVV")
        TextField(
            value = vm.cvv.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setCVV(value) },
//                onValueChange = vm::setCVV,
            placeholder = { Text(text = "000")}
        )
        Text("Exp Month")
        TextField(
            value = vm.expMonth.value,
            modifier = Modifier.padding(4.dp),
//                onValueChange = { value -> vm.setExpMonth(value) },
            onValueChange = vm::setExpMonth,
            placeholder = { Text(text = "MM")}
        )
        Text(text = "Exp Year")
        TextField(
            value = vm.expYear.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setExpYear(value) },
//                onValueChange = vm::setExpYear,
            placeholder = { Text(text = "YYYY")}
        )
        Text("Billing Address")
        TextField(
            value = vm.billingAddress.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setBillingAddress(value) },
//                onValueChange = vm::setBillingAddress,
            placeholder = { Text(text = "Ex: 123 Main Street")}
        )
        Text("Zip Code")
        TextField(
            value = vm.zipCode.value,
            modifier = Modifier.padding(4.dp),
            onValueChange = { value -> vm.setZipCode(value) },
//                onValueChange = vm::setZipCode,
            placeholder = { Text(text = "00000")}
        )
        Button(onClick = {
            try {
                val payinfo:PayInfo = vm.save()
                onAddPayInfo(payinfo)
            } catch(e: Exception) {
//                        Toast.makeText(LocalContext.current, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Save")
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF9BF8F)
fun PaymentInformationPreview() {
    val navController = rememberNavController()
    val vm: PayInfoViewModel = viewModel()
    PaymentInfo(
        navController,
        vm,
        onAddPayInfo = { payInfo ->
            vm.addPayInfo(payInfo)
        })
}
