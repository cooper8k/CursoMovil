package com.example.device

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.device.model.Device
import com.example.device.service.Constans
import com.example.device.service.DeviceService

import com.example.device.ui.theme.DeviceTheme
import com.example.device.view.MainView
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeviceTheme {
                var devices by remember { mutableStateOf(listOf<Device>()) }
                getDevice {
                    result ->
                    devices=result
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(Modifier.padding(innerPadding),
                        device = devices)
                }
            }
        }
    }

    private fun getDevice(onResult: (List<Device>)-> Unit){
        val retrofit = Retrofit.Builder().baseUrl(Constans.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(DeviceService::class.java)
        lifecycleScope.launch {
            val devices = service.GetAllDevices()
            onResult(devices)
        }
    }
}