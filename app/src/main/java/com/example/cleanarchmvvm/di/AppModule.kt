package com.example.cleanarchmvvm.di

import android.content.Context
import com.example.cleanarchmvvm.domain.usecase.GetUserNameUseCase
import com.example.cleanarchmvvm.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchmvvm.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }

//    fun provideMainViewModel(
//        getUserNameUseCase: GetUserNameUseCase,
//        saveUserNameUseCase: SaveUserNameUseCase
//    ): MainViewModel {
//        return MainViewModel(
//            getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase
//        )
//    }

}