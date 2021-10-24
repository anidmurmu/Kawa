package com.example.kawa.ui.infolist

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kawa.R
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.ui.KawaApplication

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
        private val ivProfilePic = view.findViewById<ImageView>(R.id.ivPicture)
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvStreet = view.findViewById<TextView>(R.id.tvStreet)
        private val tvCountryAndPostCode = view.findViewById<TextView>(R.id.tvCountryAndPostCode)
        private val tvTimezone = view.findViewById<TextView>(R.id.tvTime)
        private val tvGender = view.findViewById<TextView>(R.id.tvGender)


        fun bindView(personInfoUiModel: PersonInfoUiModel) {
            val spannableName = SpannableString(personInfoUiModel.name)
            val styleSpanBold = StyleSpan(Typeface.BOLD)
            val underlineSpan = UnderlineSpan()
            spannableName.setSpan(
                underlineSpan, 0, personInfoUiModel.name.length,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            tvName.text = spannableName

            val street = personInfoUiModel.streetNumber + ", " + personInfoUiModel.streetName
            val spannableStreet = SpannableString(street)
            val foregroundPurpleSpanColor = ForegroundColorSpan(
                KawaApplication.instance.resources.getColor(
                    R.color.purple
                )
            )

            spannableStreet.setSpan(
                foregroundPurpleSpanColor,
                0,
                personInfoUiModel.streetNumber.length,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            spannableStreet.setSpan(
                styleSpanBold,
                0,
                personInfoUiModel.streetNumber.length,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            tvStreet.text = spannableStreet

            val countryAndPostcodeSpan = SpannableString(personInfoUiModel.country
            + ", "
            + personInfoUiModel.postCode)

            countryAndPostcodeSpan.setSpan(
                styleSpanBold,
                0,
                personInfoUiModel.country.length,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE
            )
            tvCountryAndPostCode.text = countryAndPostcodeSpan


            val timezoneSpan = SpannableString(personInfoUiModel.timezoneOffset
                    + "- "
                    + personInfoUiModel.timezoneDesc)
            tvTimezone.text = timezoneSpan

            tvGender.text = personInfoUiModel.gender.replaceFirstChar { it.uppercaseChar() }
        }
    }
}