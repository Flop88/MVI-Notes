package ru.mvlikhachev.myapplication1122.presentation.screen.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.mvlikhachev.myapplication1122.domain.usecase.LoadNotesUseCase
import ru.mvlikhachev.myapplication1122.presentation.screen.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    loadNotesUseCase: LoadNotesUseCase
) : BaseViewModel<MainScreenState, MainScreenEvent>() {

    private val reducer = MainScreenReducer(
        initial = MainScreenState.initial(),
        useCase = loadNotesUseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<MainScreenState>
        get() = reducer.state

    init {
        sendEvent(MainScreenEvent.LoadingData)
    }

    fun sendEvent(event: MainScreenEvent) {
        reducer.sendEvent(event)
    }

}