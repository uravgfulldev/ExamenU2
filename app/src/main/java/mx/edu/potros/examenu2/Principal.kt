package mx.edu.potros.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var detalles: Button = findViewById(R.id.btn_detalles)
        var regalos: Button = findViewById(R.id.btn_regalos)
        var globos: Button = findViewById(R.id.btn_globos)
        var peluches: Button = findViewById(R.id.btn_peluches)
        var tazas: Button = findViewById(R.id.btn_tazas)
        var opcion: String= ""

        detalles.setOnClickListener{

            opcion="Detalles"
            var intento = Intent(this, Regalos::class.java)
            intento.putExtra("opcion", opcion)
            startActivity(intento)

        }

        regalos.setOnClickListener{

            opcion="Regalos"
            var intento = Intent(this, Regalos::class.java)
            intento.putExtra("opcion", opcion)
            startActivity(intento)

        }

        globos.setOnClickListener{

            opcion="Globos"
            var intento = Intent(this, Regalos::class.java)
            intento.putExtra("opcion", opcion)
            startActivity(intento)

        }

        peluches.setOnClickListener{

            opcion="Peluches"
            var intento = Intent(this, Regalos::class.java)
            intento.putExtra("opcion", opcion)
            startActivity(intento)

        }

        tazas.setOnClickListener{
            opcion="Tazas"
            var intento = Intent(this, Regalos::class.java)
            intento.putExtra("opcion", opcion)
            startActivity(intento)

        }


    }
}