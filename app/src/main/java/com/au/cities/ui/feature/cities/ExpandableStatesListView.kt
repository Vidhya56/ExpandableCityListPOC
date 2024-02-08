package com.au.cities.ui.feature.cities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.au.cities.R
import com.au.cities.data.source.local.entity.CityEntity
import com.au.cities.ui.OrderType
import com.au.cities.ui.UiState
import com.au.cities.ui.theme.Dimensions.padding
import com.au.cities.ui.theme.Dimensions.spaceSmall
import com.au.cities.ui.viewmodel.CitiesViewModel

@Composable
fun ExpandableStatesListView() {
    val viewModel: CitiesViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Box(Modifier.fillMaxSize()) {
        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(padding)
                        .align(Alignment.Center)
                )
            }

            is UiState.Success -> {
                val states = (uiState as UiState.Success<List<CityEntity>>).data.toList()
                Column(Modifier.fillMaxWidth()) {

                    Button(
                        onClick = if (viewModel.sortOrder == OrderType.ASCENDING) viewModel::getAllCitiesDesc else viewModel::getAllCitiesAsc,
                        Modifier
                            .align(Alignment.End)
                            .padding(spaceSmall)
                    ) {
                            Text(text = if (viewModel.sortOrder == OrderType.ASCENDING) stringResource(R.string.sort_descending)
                            else stringResource(R.string.sort_ascending))
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = padding)
                    ) {
                        items(states.size) { model ->
                            ExpandableSectionItem(selectedCity = states[model])
                        }
                    }
                }
            }

            is UiState.Error -> {
               ErrorView(error = (uiState as UiState.Error).error)
            }
        }
    }
}







