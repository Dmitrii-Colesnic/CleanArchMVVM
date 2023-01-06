package com.example.cleanarchmvvm.domain.usecase

import com.example.cleanarchmvvm.domain.UserRepository
import com.example.cleanarchmvvm.domain.model.SaveUserNameParam

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getUser()
        if (oldUserName.firstName == param.name)
            return true

        return userRepository.saveUserName(saveUserName = param)

    }

}