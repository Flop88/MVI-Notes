package ru.mvlikhachev.myapplication1122.domain.model

import java.time.LocalDate

data class NoteModel(
    val id: Long,
    val title: String,
    val subtitle: String,
    val date: LocalDate,
    val author: String
)
