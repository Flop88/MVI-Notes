package ru.mvlikhachev.myapplication1122.domain.repository

import ru.mvlikhachev.myapplication1122.domain.model.NoteModel

interface DomainRepository {
    suspend fun getAllNotes(): List<NoteModel>
}