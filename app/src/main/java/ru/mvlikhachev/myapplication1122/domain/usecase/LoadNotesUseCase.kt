package ru.mvlikhachev.myapplication1122.domain.usecase

import ru.mvlikhachev.myapplication1122.domain.model.NoteModel
import ru.mvlikhachev.myapplication1122.data.DomainRepositoryImpl
import ru.mvlikhachev.myapplication1122.domain.repository.DomainRepository
import javax.inject.Inject

class LoadNotesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
): BaseUseCase<List<NoteModel>>() {

    override suspend fun invoke(): List<NoteModel> = domainRepository.getAllNotes()
}