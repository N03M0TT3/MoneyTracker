package fr.imaginnovation.moneytracker

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get

class AddFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_flow)

        val database = Database(this)

        val buttonBack = findViewById<ImageView>(R.id.flowBackButton)
        val editNameFlow = findViewById<EditText>(R.id.flowFlowNameInput)
        val editValueFlow = findViewById<EditText>(R.id.flowFlowValueInput)
        val radioNatureFlow = findViewById<RadioGroup>(R.id.flowRadioGroupInputOutput)
        val spinnerPaymentMethod = findViewById<Spinner>(R.id.flowPaymentMethodSpinner)
        val editNoteFlow = findViewById<EditText>(R.id.flowFlowNoteInput)
        val buttonAddFlow = findViewById<Button>(R.id.flowAddFlowButton)

        buttonBack.setOnClickListener {
            Toast.makeText(this, "Wesh", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonAddFlow.setOnClickListener {
            val name = editNameFlow.text.toString()
            val value = editValueFlow.text.toString()

            // The value of idRadio will depend on the radio button checked by the user
            val idRadio = radioNatureFlow.checkedRadioButtonId
            val radioChoice = findViewById<RadioButton>(idRadio)
            val method = radioChoice.text.toString()

            val note = editNoteFlow.text.toString()



            val db = database.writableDatabase

            val values = ContentValues().apply {
                put(DatabaseInfo.TableInfo.COLUMN_FLOW_VALUE, value)
                put(DatabaseInfo.TableInfo.COLUMN_FLOW_NAME, name)
                put(DatabaseInfo.TableInfo.COLUMN_FLOW_METHOD, method)
                put(DatabaseInfo.TableInfo.COLUMN_FLOW_DATE, "TODAY")
                put(DatabaseInfo.TableInfo.COLUMN_FLOW_NOTE, note)
            }

            val newRowId = db?.insert(DatabaseInfo.TableInfo.TABLE_NAME, null, values)

            if(newRowId?.toInt() == -1) {
                Toast.makeText(this, "Problem with the database", Toast.LENGTH_LONG).show()
            }

            // Rajouter ?? la base de donn??es une ligne avec les informations r??colt??es
            // Repartir sur le vue pr??c??dente

            Toast.makeText(this, "Nouveau flow : $name de $value euros | ${radioChoice.text}", Toast.LENGTH_LONG).show()
        }
    }
}