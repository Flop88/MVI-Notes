package ru.mvlikhachev.myapplication1122.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}