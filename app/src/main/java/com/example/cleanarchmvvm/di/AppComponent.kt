package com.example.cleanarchmvvm.di

import androidx.lifecycle.ViewModel
import com.example.cleanarchmvvm.domain.usecase.GetUserNameUseCase
import com.example.cleanarchmvvm.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchmvvm.presentation.MainActivity
import com.example.cleanarchmvvm.presentation.MainViewModel
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}