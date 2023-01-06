package com.example.cleanarchmvvm.data

import com.example.cleanarchmvvm.data.sharedprefs_storage.User
import com.example.cleanarchmvvm.data.sharedprefs_storage.UserStorage
import com.example.cleanarchmvvm.domain.UserRepository
import com.example.cleanarchmvvm.domain.model.SaveUserNameParam
import com.example.cleanarchmvvm.domain.model.UserName

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun getUser(): UserName {
        val user = userStorage.get()
        return mapToUserName(user = user)
    }

    override fun saveUserName(saveUserName: SaveUserNameParam): Boolean {
        val user = mapToUser(saveUserName = saveUserName)
        userStorage.save(user)
        return true
    }

    private fun mapToUserName(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }

    private fun mapToUser(saveUserName: SaveUserNameParam): User {
        return User(saveUserName.name, "")
    }

}