package ambush

import Classes.Global
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import apps.ambush.R

class weaponsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapons)
        Buttons()
    }
    fun Buttons() {
        val hand = findViewById(R.id.hand) as ImageButton?
        val knife = findViewById(R.id.knife) as ImageButton?
        val pistol = findViewById(R.id.pistol) as ImageButton?
        val ak47 = findViewById(R.id.ak47) as ImageButton?
        val sniper = findViewById(R.id.sniper) as ImageButton?
        val grenade = findViewById(R.id.grenade) as ImageButton?
        val intent = Intent(this@weaponsActivity, purchaseWeaponActivity::class.java)
        hand!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[0].name)
            intent.putExtra("id",Global.weapons[0].id)
            intent.putExtra("accuracy",Global.weapons[0].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[0].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[0].damagePointHigh)
            intent.putExtra("Price",Global.weapons[0].price)
            intent.putExtra("Lose",Global.weapons[0].lose)
            intent.putExtra("url",Global.weapons[0].imageUrl)
            startActivity(intent)

        }
        knife!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[1].name)
            intent.putExtra("id",Global.weapons[1].id)
            intent.putExtra("accuracy",Global.weapons[1].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[1].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[1].damagePointHigh)
            intent.putExtra("Price",Global.weapons[1].price)
            intent.putExtra("Lose",Global.weapons[1].lose)
            intent.putExtra("url",Global.weapons[1].imageUrl)
            startActivity(intent)
        }
        pistol!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[2].name)
            intent.putExtra("id",Global.weapons[2].id)
            intent.putExtra("accuracy",Global.weapons[2].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[2].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[2].damagePointHigh)
            intent.putExtra("Price",Global.weapons[2].price)
            intent.putExtra("Lose",Global.weapons[2].lose)
            intent.putExtra("url",Global.weapons[2].imageUrl)
            startActivity(intent)
        }
        ak47!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[3].name)
            intent.putExtra("id",Global.weapons[3].id)
            intent.putExtra("accuracy",Global.weapons[3].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[3].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[3].damagePointHigh)
            intent.putExtra("Price",Global.weapons[3].price)
            intent.putExtra("Lose",Global.weapons[3].lose)
            intent.putExtra("url",Global.weapons[3].imageUrl)
            startActivity(intent)
        }
        sniper!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[4].name)
            intent.putExtra("id",Global.weapons[4].id)
            intent.putExtra("accuracy",Global.weapons[4].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[4].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[4].damagePointHigh)
            intent.putExtra("Price",Global.weapons[4].price)
            intent.putExtra("Lose",Global.weapons[4].lose)
            intent.putExtra("url",Global.weapons[4].imageUrl)
            startActivity(intent)
        }
        grenade!!.setOnClickListener {
            intent.putExtra("name", Global.weapons[5].name)
            intent.putExtra("id",Global.weapons[5].id)
            intent.putExtra("accuracy",Global.weapons[5].accuracyModifier)
            intent.putExtra("DamageLow",Global.weapons[5].damagePointLow)
            intent.putExtra("DamageHigh",Global.weapons[5].damagePointHigh)
            intent.putExtra("Price",Global.weapons[5].price)
            intent.putExtra("Lose",Global.weapons[5].lose)
            intent.putExtra("url",Global.weapons[5].imageUrl)
            startActivity(intent)
        }

    }
    companion object{

    }
}
