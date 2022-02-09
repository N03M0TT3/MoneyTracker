package fr.imaginnovation.moneytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get

class AddFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_flow)

        val buttonBack = findViewById<ImageView>(R.id.main2BackButton)
        val editNameFlow = findViewById<EditText>(R.id.flowFlowNameInput)
        val editValueFlow = findViewById<EditText>(R.id.flowFlowValueInput)
        val radioNatureFlow = findViewById<RadioGroup>(R.id.flowRadioGroupInputOutput)
        val spinnerPaymentMethod = findViewById<Spinner>(R.id.flowPaymentMethodSpinner)
        val buttonAddFlow = findViewById<Button>(R.id.flowAddFlowButton)

        buttonBack.setOnClickListener {
            Toast.makeText(this, "Wesh", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonAddFlow.setOnClickListener {
            val name = editNameFlow.text
            val value = editValueFlow.text

            // The value of idRadio will depend on the radio button checked by the user
            val idRadio = radioNatureFlow.checkedRadioButtonId
            val radioChoice = findViewById<RadioButton>(idRadio)

            // Rajouter à la base de données une ligne avec les informations récoltées
            // Repartir sur le vue précédente

            Toast.makeText(this, "Nouveau flow : $name de $value euros | ${radioChoice.text}", Toast.LENGTH_LONG).show()
        }
    }
}