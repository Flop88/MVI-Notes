package ru.mvlikhachev.myapplication1122.presentation.screen.main

import androidx.compose.runtime.Immutable
import ru.mvlikhachev.myapplication1122.domain.model.NoteModel
import ru.mvlikhachev.myapplication1122.presentation.screen.base.UiState

@Immutable
data class MainScreenState(
    val isLoading: Boolean,
    val data: List<NoteModel>,
    val error: String? = null
) : UiState {
    companion object {
        fun initial() = MainScreenState(isLoading = true, data = emptyList(), error = null)
    }
}