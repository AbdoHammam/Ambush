package ambush

import Adapters.gridInScoreboardAdapter
import Classes.Global
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.BaseAdapter
import android.widget.ListView
import apps.ambush.R
import java.util.*

class scoreboardActivity : AppCompatActivity() {

    private val arr = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)
        var listView : ListView = findViewById(R.id.usersInScoreBoard) as ListView
        var adapter : BaseAdapter = gridInScoreboardAdapter(applicationContext, Global.players)
        listView.adapter = adapter
    }

}
