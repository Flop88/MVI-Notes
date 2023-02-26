package ru.mvlikhachev.myapplication1122.presentation.screen.main

import ru.mvlikhachev.myapplication1122.domain.model.NoteModel
import ru.mvlikhachev.myapplication1122.presentation.screen.base.UiEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenEvent: UiEvent {
    object LoadingData: MainScreenEvent()
    data class ShowData(val data: List<NoteModel>): MainScreenEvent()
    data class ShowError(val errorMessage: String?) : MainScreenEvent()
}