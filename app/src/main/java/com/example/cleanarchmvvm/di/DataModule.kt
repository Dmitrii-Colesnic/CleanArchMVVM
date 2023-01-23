package com.example.cleanarchmvvm.di

import android.content.Context
import com.example.cleanarchmvvm.data.UserRepositoryImpl
import com.example.cleanarchmvvm.data.sharedprefs_storage.SharedPrefsUserStorage
import com.example.cleanarchmvvm.data.sharedprefs_storage.UserStorage
import com.example.cleanarchmvvm.domain.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefsUserStorage(context = context)
    }

    @Provides
    fun providesUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}