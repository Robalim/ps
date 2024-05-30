package ru.profsoft.myapplication.presentation

import ru.profsoft.myapplication.domain.model.Location

sealed class UiState {
    class Success(val locations: List<Location>): UiState()

    class Error(val error: Throwable): UiState()

    data object Loading: UiState()
}