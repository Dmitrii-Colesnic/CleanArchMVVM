package com.example.cleanarchmvvm.domain.usecase

import com.example.cleanarchmvvm.domain.UserRepository
import com.example.cleanarchmvvm.domain.model.UserName
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getUser()
    }

}