package com.example.laba5mobile1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView : TextView
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            resultTextView.text = result
        }
    }

    fun sendButtonPress(v : View){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("firstName", firstNameEditText.text.toString())
        intent.putExtra("lastName", lastNameEditText.text.toString())
        startActivityForResult(intent, 1)
    }
}