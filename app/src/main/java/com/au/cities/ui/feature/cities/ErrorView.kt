package com.au.cities.ui.feature.cities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.au.cities.ui.theme.Dimensions.padding


@Composable
fun ErrorView(error: String) {
    Box {
        Text(
            text = error,
            style = typography.titleMedium,
            modifier = Modifier
                .padding(padding)
                .align(Alignment.Center)
        )
    }
}