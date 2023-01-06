package com.example.cleanarchmvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchmvvm.data.UserRepositoryImpl
import com.example.cleanarchmvvm.data.sharedprefs_storage.SharedPrefsUserStorage
import com.example.cleanarchmvvm.domain.usecase.GetUserNameUseCase
import com.example.cleanarchmvvm.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy { UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepositoryImpl) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepositoryImpl) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}