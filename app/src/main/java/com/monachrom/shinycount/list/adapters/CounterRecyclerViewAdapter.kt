package com.monachrom.shinycount.list.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.monachrom.shinycount.R


import com.monachrom.shinycount.list.ui.CounterListFragment.OnListFragmentInteractionListener
import com.monachrom.shinycount.dummy.DummyContent.DummyItem
import com.monachrom.shinycount.main.data.Counter

import kotlinx.android.synthetic.main.fragment_counter_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class CounterRecyclerViewAdapter(
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<CounterRecyclerViewAdapter.ViewHolder>() {

    var values: List<Counter> = emptyList()
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Counter
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            listener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_counter_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        holder.pokemonView.text = item.pokemon

        with(holder.view) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.item_name
        val pokemonView: TextView = view.item_pokemon

        override fun toString(): String {
            return super.toString() + " '" + nameView.text + "'"
        }
    }
}
