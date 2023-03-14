package mx.edu.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var catalogo: ArrayList<Detalles> = ArrayList<Detalles>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        val opcion: String? = intent.getStringExtra("opcion")
        agregarRegalos(opcion)

        var listaRegalos: GridView = findViewById(R.id.catalogo_detalles) as GridView

        var adapter : RegalosAdapter= RegalosAdapter(catalogo,this)

        listaRegalos.adapter=adapter
    }

    fun agregarRegalos(opcion: String?){
        when(opcion){
            "Detalles" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Detalles"
            }

            "Globos" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Globos"
            }

            "Peluches" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Peluches"
            }

            "Regalos" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Regalos"
            }

            "Tazas" ->{
                catalogo.add(Detalles(R.drawable.cumplebotanas, "250"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "250"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "250"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "250"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "250"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Tazas"
            }

            else-> println("No es una opcion valida")
    }
}
    class RegalosAdapter : BaseAdapter {
        var detalles = ArrayList<Detalles>()
        var contexto: Context? = null

        constructor(catalogo: ArrayList<Detalles>, context: Context) : super() {
            this.detalles = catalogo
            this.contexto = context
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(p0: Int): Any {
            return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var regalo = detalles[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.activity_detalles_regalos, null)
            var imagen = vista.findViewById(R.id.iv_regalo_imagen) as ImageView
            var precio = vista.findViewById(R.id.precio) as TextView

            imagen.setImageResource(regalo.image)
            precio.setText("$${regalo.precio}")

            imagen.setOnClickListener {
                var intent = Intent(contexto, DetallesRegalos::class.java)
                intent.putExtra("precio", "$${regalo.precio}")
                intent.putExtra("image", regalo.image)
                contexto!!.startActivity(intent)
            }
            return vista
        }
    }
    }