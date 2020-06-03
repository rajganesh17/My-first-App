package com.example.coffeehouse.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class connectionManager {
    fun checkconnectivity(context: Context):Boolean{
        val ConnectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork:NetworkInfo?=ConnectivityManager.activeNetworkInfo
        if(activeNetwork?.isConnected!=null){
            return activeNetwork.isConnected
                   }
        else{
            return false
        }
    }
}