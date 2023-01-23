package com.example.cleanarchmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchmvvm.R
import com.example.cleanarchmvvm.app.App
import com.example.cleanarchmvvm.data.UserRepositoryImpl
import com.example.cleanarchmvvm.data.sharedprefs_storage.SharedPrefsUserStorage
import com.example.cleanarchmvvm.data.sharedprefs_storage.UserStorage
import com.example.cleanarchmvvm.domain.model.SaveUserNameParam
import com.example.cleanarchmvvm.domain.usecase.GetUserNameUseCase
import com.example.cleanarchmvvm.domain.usecase.SaveUserNameUseCase
import java.util.prefs.PreferencesFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvGetData = findViewById<TextView>(R.id.tvGetData)
        val btnGetData = findViewById<Button>(R.id.btnGetData)
        val etEnterUser = findViewById<EditText>(R.id.etEnterData)
        val btnSaveData = findViewById<Button>(R.id.btnSaveData)

//        viewModel = ViewModelProvider(this, MainViewModelFactory(applicationContext)).get(MainViewModel::class.java)

        (applicationContext as App).appComponent.inject(mainActivity = this)

        viewModel.resultLive.observe(this) {
            tvGetData.text = it
        }

        btnSaveData.setOnClickListener {
            viewModel.saveUserName(etEnterUser.text.toString())
        }

        btnGetData.setOnClickListener {
            viewModel.getUser()
        }

    }

}