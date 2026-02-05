package mx.edu.itson.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etC: EditText = findViewById(R.id.etC)
        val etF: EditText = findViewById(R.id.etF)
        val etK: EditText = findViewById(R.id.etK)

        val btnGC: Button = findViewById(R.id.btnGC)
        val btnGF: Button = findViewById(R.id.btnGF)
        val btnGK: Button = findViewById(R.id.btnGK)

        btnGC.setOnClickListener {
            val c = etC.text.toString().toDoubleOrNull()
            if (c != null) {
                val f = (c * 1.8) + 32
                val k = c + 273.15
                etF.setText(String.format("%.2f", f))
                etK.setText(String.format("%.2f", k))
            } else {
                Toast.makeText(this, "Ingresa un valor en Celsius", Toast.LENGTH_SHORT).show()
            }
        }

        btnGF.setOnClickListener {
            val f = etF.text.toString().toDoubleOrNull()
            if (f != null) {
                val c = (f - 32) / 1.8
                val k = ((5.0 * (f - 32.0)) / 9.0) + 273.15
                etC.setText(String.format("%.2f", c))
                etK.setText(String.format("%.2f", k))
            } else {
                Toast.makeText(this, "Ingresa un valor en Fahrenheit", Toast.LENGTH_SHORT).show()
            }
        }

        btnGK.setOnClickListener {
            val k = etK.text.toString().toDoubleOrNull()
            if (k != null) {
                val c = k - 273.15
                val f = ((9.0 * (k - 273.15)) / 5.0) + 32
                etC.setText(String.format("%.2f", c))
                etF.setText(String.format("%.2f", f))
            } else {
                Toast.makeText(this, "Ingresa un valor en Kelvin", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}