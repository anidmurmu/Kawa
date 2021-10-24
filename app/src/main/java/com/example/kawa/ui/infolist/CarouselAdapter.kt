package com.example.kawa.ui.infolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kawa.R
import com.example.kawa.domain.model.PersonInfoUiModel

class CarouselAdapter(private val personInfoList: List<PersonInfoUiModel>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_carousel,
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
        private val profilePic = view.findViewById<ImageView>(R.id.ivPicture)
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val street = view.findViewById<TextView>(R.id.tvStreet)
        private val countryAndPostCode = view.findViewById<TextView>(R.id.tvCountryAndPostCode)
        private val gender = view.findViewById<TextView>(R.id.tvGender)
        fun bindView(personInfoUiModel: PersonInfoUiModel) {
            name.text = personInfoUiModel.name
        }
    }
}