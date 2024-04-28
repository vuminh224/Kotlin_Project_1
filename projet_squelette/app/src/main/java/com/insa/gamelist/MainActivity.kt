package com.insa.gamelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.insa.gamelist.databinding.ActivityMainBinding
import com.insa.gamelist.utils.DataManager
import com.insa.gamelist.utils.Game
import com.insa.gamelist.utils.GameAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Q5+7
        //we have to add return statement for readfile to return List<Game>
       // val games= DataManager.readFile(this)

        /*Log.d("Q5",""+games?.size)
        Log.d("Q5",""+games?.first())
        Log.d("Q5",""+games?.last())
        // fin Q5
        */
        //TP2
        /*
        //Q8
        // TODO : display the game list in alphabetic order
        val game_alphabetic= games?.sortedBy { it.title }
        game_alphabetic?.forEach{
            Log.d("Q8",""+it.title)
        }

        //Q9
        // TODO : find and display all "Action-Aventure" game
        val game_action= games?.sortedBy { it.type == "Action-Aventure" }

        //Q10
        // TODO : find and display the games launched the 14/05/2021 and the 26/10/2021
        //timestamp 14/5/2021 00:00:00 1620950400
        //timestamp 26/10/2021 23:59:59 1635292799
        val game_date=games?.sortedBy { (it.timestamp>= 1620950400)&&(it.timestamp<= 1635292799) }

        //Q11
        // TODO : display the oldest game launched in the list
        Log.d("Q11",""+games?.minByOrNull { it.timestamp })

        //Q12
        // TODO : display the list of editor
        val List_Editor: MutableSet<String> = mutableSetOf()
        games?.forEach {
            List_Editor.add(it.editor)
        }

        //Q13
        // TODO : display the last game launched in 2020
        val game_2020=games?.sortedBy { (it.timestamp>= 1577836800)&&(it.timestamp<= 1609459199) }
        Log.d("Q13",""+game_2020?.maxByOrNull { it.timestamp })

        //Q14
        // TODO : display the average year launch for the game list
        var year:Long= 0
        games?.forEach {
            year =year+it.timestamp
        }

        if(games?.size!=null){
            year=year/games.size
        }
        Log.d("Q14",""+year)
        val BacktoDate: Date= Date(year)
        Log.d("Q14",""+BacktoDate) // WTF 1970

        //Q15
        // TODO : display the number of game launch on all platforms
        val game_allplatform = games?.sortedBy { it.console.size==6 }
        */
//        val gameAdapter = GameAdapter(games!!)
//        val rv=findViewById<RecyclerView>(R.id.rvGames)
//        rv.adapter=gameAdapter
//        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}

