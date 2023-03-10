package com.example.cleanarchmvvm.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchmvvm.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvGetData = findViewById<TextView>(R.id.tvGetData)
        val btnGetData = findViewById<Button>(R.id.btnGetData)
        val etEnterUser = findViewById<EditText>(R.id.etEnterData)
        val btnSaveData = findViewById<Button>(R.id.btnSaveData)

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