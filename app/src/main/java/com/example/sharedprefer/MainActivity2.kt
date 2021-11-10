package com.example.sharedprefer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var IntTV: TextView
    lateinit var SharTV: TextView
    lateinit var SharedBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        IntTV = findViewById(R.id.IntTV)
        SharTV = findViewById(R.id.SharTV)
        SharedBtn = findViewById(R.id.SharedBtn)

        IntTV.setText(intent.getStringExtra("IntentData"))

        SharedBtn.setOnClickListener {
            val sharedPreferences =
                this.getSharedPreferences("TextView", Context.MODE_PRIVATE)
            SharTV.setText( sharedPreferences.getString("Data",""))
        }

    }//end oncreate

}//end class