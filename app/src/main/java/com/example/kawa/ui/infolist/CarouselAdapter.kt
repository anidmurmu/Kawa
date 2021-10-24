package com.example.kawa.ui.infolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kawa.R
import com.example.kawa.domain.model.PersonInfoUiModel

class CarouselAdapter(private val personInfoList: List<PersonInfoUiModel>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_caraousel,
            parent,
            false
        )
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bindView(personInfoList[position])
    }

    override fun getItemCount(): Int {
        return personInfoList.size
    }

    inner class CarouselViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewEmail: TextView = view.findViewById<TextView>(R.id.tvEmail)
        fun bindView(personInfoUiModel: PersonInfoUiModel) {
            textViewEmail.text = personInfoUiModel.email
        }
    }
}