package com.example.pizzaapp

import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.model.MenuModel
import org.w3c.dom.Text

class MakananAdapter (private val list: ArrayList<MenuModel>):
    RecyclerView.Adapter<MakananAdapter.MakananViewHolder>(){
        inner class MakananViewHolder(v: View):RecyclerView.ViewHolder(v){
            val textId: TextView
            val textNama: TextView
            val textHarga : TextView
            val imageMenu : ImageView

            init {
                textId = v.findViewById(R.id.textIdMakanan)
                textNama = v.findViewById(R.id.textNamaMakanan)
                textHarga = v.findViewById(R.id.textHargaMakanan)
                imageMenu = v.findViewById(R.id.imageMakanan)
            }

            fun bind(data: MenuModel){
                val id : Int = data.id
                val nama : String = data.name
                val harga : Int = data.price
                val gambar : Bitmap = data.image

                textId.text = id.toString()
                textNama.text = nama
                textHarga.text = harga.toString()
                imageMenu.setImageURI(gambar)
            }
        }
    }