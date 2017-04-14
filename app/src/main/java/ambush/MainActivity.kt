package ambush

import Classes.Global
import android.app.Activity
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import apps.ambush.R
internal class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Global.getAllPlayers()
        Global.getAllWeapons()
        val i = Intent(this@MainActivity, loginActivity::class.java)
        startActivity(i)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()

    }
    companion object{
        var mLocationManager: LocationManager ?= null
    }
}