package com.example.cleanarchmvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchmvvm.domain.model.SaveUserNameParam
import com.example.cleanarchmvvm.domain.usecase.GetUserNameUseCase
import com.example.cleanarchmvvm.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    fun saveUserName(text: String) {
        val param = SaveUserNameParam(name = text)
        val result = saveUserNameUseCase.execute(param = param)
        resultLiveMutable.value = "Save result: $result"
    }

    fun getUser() {
        val result = getUserNameUseCase.execute()
        resultLiveMutable.value = "${result.firstName} ${result.lastName}"
    }

}