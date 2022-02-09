package fr.imaginnovation.moneytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddNewFlow = findViewById<Button>(R.id.mainNewFlowButton)
        val textCurrentBalance = findViewById<TextView>(R.id.mainCurrentBalanceText)

        buttonAddNewFlow.setOnClickListener {
            Toast.makeText(this, "New flow added", Toast.LENGTH_SHORT).show()
            val balance = 150
            textCurrentBalance.text = "New Balance : $balance"

            val intent = Intent(this, AddFlowActivity::class.java)

            startActivity(intent)
        }
    }



}