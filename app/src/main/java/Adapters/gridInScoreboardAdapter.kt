package Adapters

import Classes.Player
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import apps.ambush.R
import java.util.*


class gridInScoreboardAdapter(mContext: Context,Players:ArrayList<Player>) : BaseAdapter() {
    var context : Context = mContext
    var players : ArrayList<Player> = Players
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var holder = Holder()
        if(convertView == null){

            gridInGameAdapter.convertView = LayoutInflater.from(context).inflate(R.layout.list_item_in_scoreboard, null)
            holder.userScoreInScoreboard = convertView!!.findViewById(R.id.usernameInScoreboard) as TextView?
            holder.usernameInScoreboard = convertView!!.findViewById(R.id.userScoreInScoreboard) as TextView?
            convertView!!.tag = holder
        } else {
            holder = convertView!!.tag as Holder
        }
        return convertView as View
    }

    override fun getItem(p0: Int): Player {
        return players[p0]
    }

    override fun getItemId(p0: Int): Long {
        val toLong = players[p0].id.toLong()
        return toLong
    }

    override fun getCount(): Int {
        val size = players.size
        return size
    }
    class Holder{
        var usernameInScoreboard : TextView ?=null
        var userScoreInScoreboard : TextView ?=null
    }
    companion object{
        var convertView : View ?=null

    }
}