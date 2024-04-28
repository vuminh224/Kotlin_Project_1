package com.insa.gamelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.insa.gamelist.utils.DataManager
import com.insa.gamelist.utils.GameAdapter

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val games= DataManager.readFile(view.context)
        val gameAdapter = GameAdapter(games!!)
        val rv= view.findViewById<RecyclerView>(R.id.rvGames)
        rv.adapter=gameAdapter
        rv.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
        return view
    }
}
