package com.au.cities.ui.feature.cities

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.au.cities.R

import com.au.cities.data.source.local.entity.CityEntity
import com.au.cities.ui.theme.Dimensions.cardElevation
import com.au.cities.ui.theme.Dimensions.padding
import com.au.cities.ui.theme.Dimensions.cornerSize
import com.au.cities.ui.theme.Dimensions.spaceLarge
import com.au.cities.ui.theme.Dimensions.spaceXXSmall

@Composable
fun ExpandableSectionItem(selectedCity: CityEntity) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(cardElevation),
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(corner = CornerSize(cornerSize)
        )
    ) {

        val icon =
            if (isExpanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown

        Box(
            modifier = Modifier
                .padding(spaceXXSmall)
                .fillMaxWidth(),
        )
        {
            Text(
                text = selectedCity.city,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(padding)
            )
            Image(
                modifier = Modifier
                    .size(spaceLarge)
                    .align(Alignment.CenterEnd),
                imageVector = icon,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer),
                contentDescription = stringResource(id = R.string.expand_or_collapse),
            )
        }
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth(),
            visible = isExpanded
        ) {
            DetailsView(selectedCity = selectedCity)
        }
    }
}
