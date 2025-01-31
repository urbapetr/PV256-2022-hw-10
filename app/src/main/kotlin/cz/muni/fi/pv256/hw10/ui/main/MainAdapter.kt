package cz.muni.fi.pv256.hw10.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ViewSwitcher
import androidx.recyclerview.widget.RecyclerView
import cz.muni.fi.pv256.hw10.R
import cz.muni.fi.pv256.hw10.data.NamedApiResource
import cz.muni.fi.pv256.hw10.databinding.ListItemBinding

class MainAdapter(private val empty: ViewSwitcher, private val onClick: (NamedApiResource) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items = listOf<NamedApiResource>()
        set(value) {
            field = value
            notifyDataSetChanged()
            if (value.isEmpty()) {
                if (empty.currentView.id != R.id.empty) {
                    empty.showNext()
                }
            } else if (empty.currentView.id != R.id.recycler_view) {
                empty.showNext()
            }
        }

    class ViewHolder(itemBinding: ListItemBinding, val onClick: (NamedApiResource) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {
        private val text = itemBinding.title

        fun bind(namedApiResource: NamedApiResource) {
            text.text = namedApiResource.name.capitalize()
            itemView.setOnClickListener { onClick(namedApiResource) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick,
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
