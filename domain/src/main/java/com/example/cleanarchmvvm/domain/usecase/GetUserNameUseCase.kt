package com.example.cleanarchmvvm.domain.usecase

import com.example.cleanarchmvvm.domain.UserRepository
import com.example.cleanarchmvvm.domain.model.UserName

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getUser()
    }

}