package com.example.device.service

import com.example.device.model.Device
import retrofit2.http.GET

interface DeviceService {

    @GET(Constans.OBJECTS_PATH)
    suspend fun GetAllDevices(): List<Device>

}