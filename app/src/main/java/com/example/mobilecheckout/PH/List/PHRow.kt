package com.example.mobilecheckout.PH.List

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mobilecheckout.PH.PHModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalFoundationApi
@Composable
fun PHRow (
    nav : NavController,
    vm: PHListViewModel = viewModel(),
    purchase: PHModel,
){
    Card(
        shape = AbsoluteCutCornerShape(5.dp),
        elevation = 0.dp,
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, top = 1.dp, bottom = 1.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onClick = {
                        val url = URLEncoder.encode(purchase.itemPic, StandardCharsets.UTF_8.toString())
                        val more = purchase.itemName + "@" + url + "@" + purchase.itemDes + "@" + purchase.purchaseAmount

                        nav.navigate("moreInfo/${more}")
                        {
                            launchSingleTop = true
                        }

                    }
                )
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1.8f)
            ){
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(purchase.itemName,
                        modifier = Modifier.weight(2.0f), fontSize = 20.sp, color = MaterialTheme.colors.secondary)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Date: " + purchase.date,
                        modifier = Modifier.weight(2.0f), fontSize = 20.sp, color = MaterialTheme.colors.secondary)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val amount = purchase.purchaseAmount.toBigDecimal().toPlainString()
                    Text("Cost :$" +amount,
                        modifier = Modifier.weight(2.0f), fontSize = 20.sp, color = MaterialTheme.colors.secondary)
                }
            }
            Box(
                modifier = Modifier.weight(1.0f)
            ){

                AsyncImage(
                    modifier = Modifier.size(128.dp),
                    model = purchase.itemPic,
                    contentDescription = null
                )

            }



        }
    }
}