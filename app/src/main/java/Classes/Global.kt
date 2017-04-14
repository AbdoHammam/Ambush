package Classes

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.gson.Gson
import java.util.*

object Global {
    var players = ArrayList<Player>()
    var weapons = ArrayList<Weapon>()
    var currentPlayer = Player()
    var gang = ArrayList<Player>()
    var context : Context ?= null
    var isGang : Boolean = false
    var staticURL: String = "http://localhost:3000/api/"
    var finalResult: String? = null
    var nearPlayers = ArrayList<Player>()
    //Functions
    fun Signin(request : SignInRequest): Player {
        val builtUri = Uri.parse(staticURL + "Player/SignIn").buildUpon().build()
        val url = builtUri.toString()
        val jsonObj: Gson = Gson()
        val str: String = jsonObj.toJson(request)


        finalResult = Connection().execute(url, "POST", str).get()
        val gson: Gson = Gson()
        var response: Player = gson.fromJson(finalResult, Player::class.java)
        return response
    }


    fun Register(request : RegisterRequest): Boolean{
        val builtUri = Uri.parse(staticURL + "Player/SignUp").buildUpon().build()
        val url = builtUri.toString()
        val jsonObj: Gson = Gson()
        val str: String = jsonObj.toJson(request)


        finalResult = Connection().execute(url, "POST", str).get()
        val gson: Gson = Gson()
        var response: RegisterResponse = gson.fromJson(finalResult, RegisterResponse::class.java)
        return response.result
    }
    fun getAllPlayers(){
        val builtUri = Uri.parse(staticURL + "Player").buildUpon().build()
        val url = builtUri.toString()
        val jsonObj: Gson = Gson()
        finalResult = Connection().execute(url, "GET").get()
        val str: allPlayers = jsonObj.fromJson(finalResult,allPlayers::class.java)
        players = str.array
    }
    fun getAllWeapons(){
        val builtUri = Uri.parse(staticURL + "weapon").buildUpon().build()
        val url = builtUri.toString()
        val jsonObj: Gson = Gson()
        finalResult = Connection().execute(url, "GET").get()
        val str: allWeapons = jsonObj.fromJson(finalResult,allWeapons::class.java)
        weapons = str.array

    }
    fun getNearPlayers()  {
        getAllPlayers()
        for(player in players){
            if(Math.sqrt((player.location!!.latitude- currentPlayer.location!!.latitude)*(player.location!!.latitude- currentPlayer.location!!.latitude)+(player.location!!.latitude- currentPlayer.location!!.latitude)*(player.location!!.longitude- currentPlayer.location!!.longitude)) <= 50.0){
                nearPlayers.add(player)
            }
        }
    }
    fun updatePlayerData(player :Player){
        val builtUri = Uri.parse(staticURL + "Player/"+player.id.toString()).buildUpon().build()
        val url = builtUri.toString()
        val jsonObj: Gson = Gson()
        val str: String = jsonObj.toJson(player)

        finalResult = Connection().execute(url, "POST",str).get()
    }
    fun attackPlayerInSingleGame(victim : Player,mContext : Context){

        var rand =  Random() as Int?
        rand = rand!!.mod(100)
        if(rand < Global.currentPlayer.weapons[Global.currentPlayer.weaponChoice].accuracyModifier){
            victim.totalAmbushDefeat++
            Global.currentPlayer.points += 10
            Global.currentPlayer.totalAmbushVictory++
            Global.currentPlayer.totalPlay++
            var damagePoint = Random() as Int?
            damagePoint = damagePoint!!.mod(Global.currentPlayer.weapons[Global.currentPlayer.weaponChoice].damagePointHigh-Global.currentPlayer.weapons[Global.currentPlayer.weaponChoice].damagePointLow)
            damagePoint += Global.currentPlayer.weapons[Global.currentPlayer.weaponChoice].damagePointLow
            victim.stamina = Math.max(0,victim.stamina-damagePoint)
            if(victim.stamina == 0){
                victim.weapons.clear()
            }
            updatePlayerData(victim)
            updatePlayerData(Global.currentPlayer)
            Toast.makeText(mContext,Global.currentPlayer.ambushVictory, Toast.LENGTH_SHORT).show()
        }
        else{
            victim.totalAmbushEscape++
            Global.currentPlayer.totalPlay++
        }
    }
    fun attackPlayerInGang(victim: Player) {
        var rand = Random() as Int?
        for(player in Global.gang){
            rand = rand!!.mod(100)
            if(rand < player.weapons[player.weaponChoice].accuracyModifier){
                var damagePoint = Random() as Int?
                damagePoint = damagePoint!!.mod(100)
            }
        }
    }
}