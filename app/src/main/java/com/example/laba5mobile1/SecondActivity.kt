package com.example.laba5mobile1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var textView: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val extras = intent.extras
        val name = extras?.getString("firstName")
        val lastName = extras?.getString("lastName")

        textView = findViewById(R.id.textView1)
        textView.text = "$name $lastName"

        button1 = findViewById(R.id.button)
        button1.text = getString(R.string.hello1, name, lastName)

        button2 = findViewById(R.id.button2)
        button2.text = getString(R.string.hello2, name, lastName)

        button3 = findViewById(R.id.button3)
        button3.text = getString(R.string.hello3, name, lastName)
    }

    fun helloButtonPress(v : View){
        val intent : Intent = Intent()
        val message = (v as Button).getText().toString()
        intent.putExtra("result", message)
        setResult(RESULT_OK, intent)
        finish()
    }

}