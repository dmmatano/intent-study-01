package com.example.intentstudyapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extras = intent?.extras?.getString("message")
        val title = findViewById<TextView>(R.id.title)
        val btn = findViewById<Button>(R.id.button)
        val chooserBtn = findViewById<Button>(R.id.buttonChooser)

        title.text = extras
        btn.setOnClickListener { executeImplicitIntent(false) }
        chooserBtn.setOnClickListener { executeImplicitIntent(true) }


    }

    private fun executeImplicitIntent(withChooser: Boolean) {


        if(withChooser){
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.type = "text/plain"
            sendIntent.putExtra("url", "https://i.pinimg.com/474x/62/05/83/620583a35e27d25d8426e5fd47caaba6.jpg")
            val chooser:Intent = Intent.createChooser(sendIntent, "Escolha um app para compartilhar: ")
            if(sendIntent.resolveActivity(packageManager) != null) startActivity(chooser)
        }else{
            val url = Uri.parse("https://i.pinimg.com/474x/62/05/83/620583a35e27d25d8426e5fd47caaba6.jpg")
            val implicitIntent = Intent(Intent.ACTION_VIEW, url)
            startActivity(implicitIntent)
        }


    }


}