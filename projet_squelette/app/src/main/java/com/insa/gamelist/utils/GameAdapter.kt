package com.insa.gamelist.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.insa.gamelist.R
import com.insa.gamelist.extentions.load


class GameAdapter(l: List<Game>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
   lateinit var gameView: View
    var games:List<Game> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    init {
        games = l
    }
    override fun getItemCount(): Int {
        return games.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        gameView=inflater.inflate(R.layout.un_jeu_layout,parent,false)
        return ViewHolder(gameView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game=games[position]
        holder.tvId.text=game.id.toString()
        holder.tvTitre.text=game.title
        holder.image_layout.load(game.image)
        val bundle = bundleOf("gameId" to position)
        holder.itemView.setOnClickListener(
          Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_gameFragment,bundle)
        )
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvId : TextView = itemView.findViewById(R.id.tvNum)
        val tvTitre : TextView = itemView.findViewById(R.id.tvTitre)
        val image_layout : ImageView = itemView.findViewById(R.id.image_layout)

    }
}
