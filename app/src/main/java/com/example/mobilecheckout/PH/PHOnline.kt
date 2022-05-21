package com.example.mobilecheckout.PH

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

interface IPHOnline{
    suspend fun onlinePH(): List<PHModel>
}

//api to get json info from my json server
class PHOnline : IPHOnline{
        private val URL = "https://my-json-server.typicode.com/jjggf00/Purchases/purchases" // need to create API Online for app to grab json data from
        override suspend fun onlinePH(): List<PHModel> {

            return withContext(Dispatchers.IO){
                val client = OkHttpClient()

                val request : Request = Request.Builder()
                    .get()
                    .url(URL)
                    .build()

                val response: Response = client.newCall(request).execute()

                val body : String? = response.body?.string()

                val Type = object: TypeToken<List<PHModel>>() {}.type
                Gson().fromJson<List<PHModel>>(body,Type)

            }
        }
}