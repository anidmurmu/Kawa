package com.example.kawa.ui.infolist

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import com.example.kawa.R
import com.example.kawa.domain.model.PersonInfoUiModel
import com.example.kawa.ui.base.ViewOnClickListener
import com.example.kawa.ui.base.recyclerview.BaseBindingRVModel
import com.example.kawa.ui.base.recyclerview.BaseBindingViewHolder
import com.example.kawa.ui.base.recyclerview.BaseViewHolderBindingFactory

/**
 * This class contains a factory method
 *
 */
class MainVHFactory : BaseViewHolderBindingFactory() {
    /**
     * Factory method to create corresponding ViewHolder for item view in a Recyclerview
     *
     * @param binding binding for the view
     * @param viewType view id
     * @param viewClickCallback callback for click in item view
     * @return View holder for item view
     */
    override fun create(
        binding: ViewDataBinding,
        viewType: Int,
        viewClickCallback: ViewOnClickListener?
    ): BaseBindingViewHolder<out BaseBindingRVModel> {
        return when (viewType) {
            R.layout.item_list_info -> UnselectedListItemViewHolder(binding, viewClickCallback)

            R.layout.item_list_info_selected -> SelectedListItemViewHolder(binding, viewClickCallback)

            else -> BaseBindingViewHolder(binding)
        }
    }
}

/**
 *This is a view holder for item in a recyclerview
 *
 * @property viewClickCallback A callback for view click
 *
 * @param binding A binding for view
 */
class UnselectedListItemViewHolder(
    binding: ViewDataBinding,
    private val viewClickCallback: ViewOnClickListener?
) : BaseBindingViewHolder<UnselectedListItemRVModel>(binding) {
    /**
     * This is a method when view is bind
     *
     * @param model Model for item in recycler view
     */
    override fun bindView(model: UnselectedListItemRVModel) {
        itemView.setOnClickListener {
            val position = adapterPosition
            viewClickCallback?.onViewClick(R.id.on_click_item, position)
        }
    }
}

class SelectedListItemViewHolder(
    binding: ViewDataBinding,
    private val viewClickCallback: ViewOnClickListener?
) : BaseBindingViewHolder<SelectedListItemRVModel>(binding) {
    /**
     * This is a method when view is bind
     *
     * @param model Model for item in recycler view
     */
    override fun bindView(model: SelectedListItemRVModel) {
        itemView.setOnClickListener {
            val position = adapterPosition
            viewClickCallback?.onViewClick(R.id.on_click_item, position)
        }
    }
}

/**
 * Wrapper class for item which contains model for it
 *
 * @property personInfoUiModel Model for item view
 */
class UnselectedListItemRVModel(private val personInfoUiModel: PersonInfoUiModel) :
    BaseBindingRVModel {
    /**
     * This method get the layout id for item in recycler view
     *
     * @return layout id of the item view
     */
    override fun getLayoutId(): Int {
        return R.layout.item_list_info
    }

    /**
     * This method puts list of models for the item view in recycler view
     *
     * @return It returns list of model for item view
     */
    override fun getBindingPairs(): List<Pair<Int, Any>> {
        return listOf(
            Pair(
                BR.bindingVariableModel,
                personInfoUiModel
            )
        )
    }
}
class SelectedListItemRVModel(private val personInfoUiModel: PersonInfoUiModel) :
    BaseBindingRVModel {
    /**
     * This method get the layout id for item in recycler view
     *
     * @return layout id of the item view
     */
    override fun getLayoutId(): Int {
        return R.layout.item_list_info_selected
    }

    /**
     * This method puts list of models for the item view in recycler view
     *
     * @return It returns list of model for item view
     */
    override fun getBindingPairs(): List<Pair<Int, Any>> {
        return listOf(
            Pair(
                BR.bindingVariableModel,
                personInfoUiModel
            )
        )
    }
}