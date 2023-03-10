package com.example.cleanarchmvvm.domain.usecase

import com.example.cleanarchmvvm.domain.UserRepository
import com.example.cleanarchmvvm.domain.model.SaveUserNameParam
import dagger.Component
import dagger.Subcomponent
import javax.inject.Inject

class SaveUserNameUseCase (val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getUser()
        if (oldUserName.firstName == param.name)
            return true

        return userRepository.saveUserName(saveUserName = param)

    }

}