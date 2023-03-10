package com.example.cleanarchmvvm.di

import com.example.cleanarchmvvm.data.UserRepositoryImpl
import com.example.cleanarchmvvm.data.sharedprefs_storage.SharedPrefsUserStorage
import com.example.cleanarchmvvm.data.sharedprefs_storage.UserStorage
import com.example.cleanarchmvvm.domain.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}