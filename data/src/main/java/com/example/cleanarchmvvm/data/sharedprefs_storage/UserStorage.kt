package com.example.cleanarchmvvm.data.sharedprefs_storage

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}