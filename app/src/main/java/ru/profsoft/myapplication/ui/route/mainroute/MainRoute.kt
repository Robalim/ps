package ru.profsoft.myapplication.ui.route.mainroute

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.profsoft.myapplication.presentation.MainViewModel
import ru.profsoft.myapplication.presentation.UiState

@Composable
fun MainRoute(viewModel: MainViewModel = viewModel()) {
    when (val uiState = viewModel.locations.collectAsStateWithLifecycle().value) {
        is UiState.Loading -> {
            Log.d("Some tag", "Loading")
        }
        is UiState.Error -> {
            Log.d("Some tag", uiState.error.message?: "")
        }
        is UiState.Success -> {
            MainView(uiState.locations)
        }
    }
}