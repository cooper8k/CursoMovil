package com.example.device.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.device.model.Device
import com.example.device.model.Specs
import com.example.device.ui.theme.DeviceTheme
import com.example.device.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier,device : List<Device>) {
    Column{
        Text(
            text = "Comprar",
            modifier= modifier.background(Color.LightGray).padding(10.dp).fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign= TextAlign.Center,

            )
        LazyColumn {
            items(device.size){
                index -> DeviceItemView(device[index])
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    DeviceTheme {
        MainView(Modifier.padding(top = 24.dp),listOf(
             Device(1,"nexus", Specs("rojo","128 GB")),
             Device(2,"samsung", Specs("verde","512 GB"))
        ))
    }
}