package com.example.sharedprefer

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var IntentET: EditText
    lateinit var SharedET: EditText
    lateinit var IntentBtn: Button
    lateinit var SharedBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IntentET = findViewById(R.id.IntET)
        SharedET = findViewById(R.id.SherET)
        IntentBtn = findViewById(R.id.IntBtn)
        SharedBtn = findViewById(R.id.SherBtn)

        IntentBtn.setOnClickListener{
            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("IntentData", IntentET.text.toString())
            IntentET.setText("")
            startActivity(intent)
        }

        SharedBtn.setOnClickListener {
            var sharedPreferences= this.getSharedPreferences("TextView", Context.MODE_PRIVATE)
            // We can save data with the following code
            with(sharedPreferences.edit()) {
                putString("Data",SharedET.text.toString() )
                apply()
            }
        }

    }//end oncreate

}//end class