package com.example.cleanarchmvvm.domain

import com.example.cleanarchmvvm.domain.model.SaveUserNameParam
import com.example.cleanarchmvvm.domain.model.UserName

interface UserRepository {

    fun getUser(): UserName

    fun saveUserName(saveUserName: SaveUserNameParam): Boolean

}