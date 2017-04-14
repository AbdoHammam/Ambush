package Classes

import android.location.Location
import java.util.*

class Player internal constructor()  {


    var id: Int = 0
    var name: String? = null
    var password: String? = null
    var isHuman: Boolean = false
    var coins: Int = 0
    var points: Int = 0
    var ambushVictory: String = String()
    var ambushEscape: String = String()
    var ambushCounterAttackVictory: String = String()
    var totalPlay: Int = 0
    var totalAmbushVictory: Int = 0
    var totalAmbushDefeat: Int = 0
    var totalAmbushEscape: Int = 0
    var totalAmbushCounterAttackVictory: Int = 0
    var isActive: Boolean = true
    var stamina: Int = 100
    var location : Location ?= null
    var weapons = ArrayList<Weapon>()
    var weaponChoice : Int = 0
    init {
        coins = 0
        points = 0
        isHuman = true
        totalPlay = 0
        totalAmbushVictory = 0
        totalAmbushDefeat = 0
        totalAmbushEscape = 0
        totalAmbushCounterAttackVictory = 0
        isActive = true
        weapons.add(Global.weapons[0])
        weapons.add(Global.weapons[1])
    }

}
