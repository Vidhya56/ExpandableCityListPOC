package com.au.cities.ui.feature.cities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.au.cities.R
import com.au.cities.data.source.local.entity.CityEntity
import com.au.cities.ui.theme.Dimensions.padding
import com.au.cities.ui.theme.Dimensions.spaceExtraSmall

@Composable
fun DetailsView(selectedCity: CityEntity) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = spaceExtraSmall)) {
            TextItem(label = stringResource(R.string.label_country), value = "${selectedCity.country}")
            TextItem(label = stringResource(R.string.label_state), value = "${selectedCity.admin_name}")
            TextItem(label = stringResource(R.string.label_capital), value = "${selectedCity.capital}")
            TextItem(label = stringResource(R.string.label_iso2), value = "${selectedCity.iso2}")
            TextItem(label = stringResource(R.string.label_latitude), value = "${selectedCity.lat}")
            TextItem(label = stringResource(R.string.label_longitude), value = "${selectedCity.lng}")
            TextItem(label = stringResource(R.string.label_population), value = "${selectedCity.population}")
            TextItem(label = stringResource(R.string.label_population_proper), value = "${selectedCity.population_proper}")
        }
}

@Composable
fun TextItem(label: String, value: String) {
    Text(
        text = "$label: $value",
        style = MaterialTheme.typography.titleSmall,
        fontFamily = FontFamily.Monospace,
        modifier = Modifier
            .padding(padding)
    )
}
