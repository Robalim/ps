package ru.profsoft.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import ru.profsoft.myapplication.domain.usecase.fetchlocations.IFetchLocationUseCase
import ru.profsoft.myapplication.domain.usecase.listenlocations.IListenLocationUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val fetchLocationsUseCase: IFetchLocationUseCase, private val listenLocationsUseCase: IListenLocationUseCase): ViewModel() {

    private val locationsStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val locations: StateFlow<UiState>
        get() = locationsStateFlow

    init {
        viewModelScope.launch(SupervisorJob() + Dispatchers.IO) {
            launch {
                listenLocationsUseCase().catch {
                    locationsStateFlow.emit(UiState.Error(it))
                }.collect {
                    locationsStateFlow.emit(UiState.Success(it))
                }
            }
            launch {
                fetchLocationsUseCase()
            }
        }
    }
}