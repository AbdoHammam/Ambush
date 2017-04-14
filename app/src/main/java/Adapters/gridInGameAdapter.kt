package Adapters

import Classes.Global
import Classes.Player
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import apps.ambush.R
import java.util.*


class gridInGameAdapter(context: Context,Players: ArrayList<Player>) : BaseAdapter() {
    var mContext : Context = context
    var players : ArrayList<Player> = Players
    override fun getCount(): Int {
        return 1
    }

    override fun getItem(i: Int): Player? {
        return players[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    class Holder{
        var usernameInGame : TextView = convertView!!.findViewById(R.id.usernameInGame) as TextView
        var numOfAmbushVictoryInGame : TextView = convertView!!.findViewById(R.id.numOfAmbushVictoryInGame) as TextView
        var numOfAmbushDefeatInGame : TextView = convertView!!.findViewById(R.id.numOfAmbushDefeatInGame) as TextView
        var numOfAmbushEscapeInGame : TextView = convertView!!.findViewById(R.id.numOfAmbushEscapeInGame) as TextView
        var numOfAmbushCounterAttackInGame: TextView =convertView!!.findViewById(R.id.numOfAmbushCounterAttackInGame) as TextView
        var staminaInGame : TextView = convertView!!.findViewById(R.id.staminaInGame) as TextView
        var attackButtonInGame : Button =convertView!!.findViewById(R.id.attackButtonInGame) as Button

    }
    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View? {
        var holder = Holder()
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_in_game, null)
            holder.usernameInGame.text = players[i].name
            holder.numOfAmbushVictoryInGame.text = players[i].totalAmbushVictory.toString()
            holder.numOfAmbushDefeatInGame.text = players[i].totalAmbushDefeat.toString()
            holder.numOfAmbushEscapeInGame.text = players[i].totalAmbushEscape.toString()
            holder.numOfAmbushCounterAttackInGame.text =players[i].totalAmbushCounterAttackVictory.toString()
            holder.staminaInGame.text = players[i].stamina.toString()
            holder.attackButtonInGame.setOnClickListener {
                Global.attackPlayerInSingleGame(players[i],mContext)
            }

            convertView!!.tag = holder
        } else {
            holder = convertView!!.tag as Holder
        }

        return convertView
    }
    companion object{
        var convertView : View ?=null
    }
}
