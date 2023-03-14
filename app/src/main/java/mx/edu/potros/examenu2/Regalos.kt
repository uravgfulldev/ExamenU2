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
                catalogo.add(Detalles(R.drawable.cumplebotanas, "280"))
                catalogo.add(Detalles(R.drawable.cumplecheve, "320"))
                catalogo.add(Detalles(R.drawable.cumpleescolar, "330"))
                catalogo.add(Detalles(R.drawable.cumplepaletas, "190"))
                catalogo.add(Detalles(R.drawable.cumplesnack, "150"))
                catalogo.add(Detalles(R.drawable.cumplevinos, "370"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Detalles"
            }

            "Globos" ->{
                catalogo.add(Detalles(R.drawable.globoamor, "250"))
                catalogo.add(Detalles(R.drawable.globocumple, "250"))
                catalogo.add(Detalles(R.drawable.globofestejo, "250"))
                catalogo.add(Detalles(R.drawable.globonum, "250"))
                catalogo.add(Detalles(R.drawable.globoregalo, "250"))
                catalogo.add(Detalles(R.drawable.globos, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Globos"
            }

            "Peluches" ->{
                catalogo.add(Detalles(R.drawable.peluchemario, "250"))
                catalogo.add(Detalles(R.drawable.pelucheminecraft, "250"))
                catalogo.add(Detalles(R.drawable.peluchepeppa, "250"))
                catalogo.add(Detalles(R.drawable.peluches, "250"))
                catalogo.add(Detalles(R.drawable.peluchesony, "250"))
                catalogo.add(Detalles(R.drawable.peluchestich, "250"))
                catalogo.add(Detalles(R.drawable.peluchevarios, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Peluches"
            }

            "Regalos" ->{
                catalogo.add(Detalles(R.drawable.regalos, "250"))
                catalogo.add(Detalles(R.drawable.regaloazul, "250"))
                catalogo.add(Detalles(R.drawable.regalocajas, "250"))
                catalogo.add(Detalles(R.drawable.regalocolores, "250"))
                catalogo.add(Detalles(R.drawable.regalobebe, "250"))
                catalogo.add(Detalles(R.drawable.regalovarios, "250"))
                var titulo: TextView=findViewById(R.id.titulo_detalles)
                titulo.text="Regalos"
            }

            "Tazas" ->{
                catalogo.add(Detalles(R.drawable.tazaabuela, "250"))
                catalogo.add(Detalles(R.drawable.tazas, "250"))
                catalogo.add(Detalles(R.drawable.tazalove, "250"))
                catalogo.add(Detalles(R.drawable.tazaquiero, "250"))
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