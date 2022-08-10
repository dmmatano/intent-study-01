package com.example.intentstudyapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * Intents: explícita, implícita e filtros.
 * Parametros:
 * Nome do componente -> a classe. Sem esse param, o intent vira implícito.
 * Ação
 * Dados
 * Categoria
 * Extras
 * Sinalizadores
 * Para tornar possível uma activity receber intents de outros apps, use intent filters.
 * Declare no manifest algo do tipo:
 * <activity android:name="blablaActivity">
 *     <intent-filter>
 *         <action android:name="android.intent.action.SEND"/>
 *         <category ... />
 *         <data .../>
 *     </intent-filter>
 * </activity>
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            //explicit intent
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("message","Oi, nasci na MainActivity !")
            startActivity(intent)
        }


    }

}