package com.sameer.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sameer.dailypulse.Platform

@Composable
fun AboutScreen(onUpButtonClick: () -> Unit) {
    Column {
        Toolbar(onUpButtonClick)
        contentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(onUpButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}


@Composable
private fun contentView(){
    val items = makeItems()

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second )
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()
    return listOf(
        "OS Name" to platform.osName,
        "OS Version" to platform.osVersion,
        "Device Model" to platform.deviceModel,
        "Density" to platform.density.toString()
    )
}

@Composable
private fun RowView(title: String, subtitle: String){
    Column(Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium
        )
    }
    Divider()
}
