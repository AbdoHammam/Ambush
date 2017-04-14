package ambush

import Classes.Global
import Classes.SignInRequest
import android.app.Activity
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import apps.ambush.R
import java.util.*

class loginActivity : Activity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        LoginButton()
    }

    fun LoginButton() {
        username = findViewById(R.id.editText2) as EditText?
        password = findViewById(R.id.editText3) as EditText?
        Login = findViewById(R.id.login) as Button?
        Reg = findViewById(R.id.Register)as Button?
        mLocationManager = applicationContext.getSystemService(LOCATION_SERVICE) as LocationManager
        isGPSEnabled = mLocationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
        connectivityManager = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        //networks = (connectivityManager!!.allNetworks as ArrayList<Network>?)!!
        //Toast.makeText(this@loginActivity,connectivityManager!!.activeNetworkInfo.toString(),Toast.LENGTH_SHORT).show()
        Login!!.setOnClickListener {
            val intent = Intent(this@loginActivity, userHomeActivity::class.java)
            if(!isGPSEnabled && !isNetworkEnabled)
                Toast.makeText(this@loginActivity,"Please check your internet connection and GPS",Toast.LENGTH_SHORT).show()
            else if(!isGPSEnabled)
                Toast.makeText(this@loginActivity,"Please check your GPS",Toast.LENGTH_SHORT).show()
            else {
                val providers = MainActivity.mLocationManager!!.getProviders(true)
                var bestLocation: Location?
                bestLocation = null
                for (provider in providers) {
                    val l = MainActivity.mLocationManager!!.getLastKnownLocation(provider) ?: continue
                    if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                        bestLocation = l
                    }
                }
                var loginUser: SignInRequest = SignInRequest()
                loginUser.userName = username!!.text.toString()
                loginUser.password = password!!.text.toString()
                Global.currentPlayer = Global.Signin(loginUser)
                val intent = Intent(this@loginActivity, userHomeActivity::class.java)
                startActivity(intent)
            }
        }
        Reg!!.setOnClickListener {
            val intent = Intent(this@loginActivity, registerActivity::class.java)
            if(!isNetworkEnabled)
                Toast.makeText(this@loginActivity,"Please check your network", Toast.LENGTH_SHORT).show()
            else
                startActivity(intent)
        }
    }
    companion object
    {
        private var username: EditText? = null
        private var password: EditText? = null
        private var Login: Button? = null
        private var Reg: Button? = null
        var mLocationManager: LocationManager ?= null
        var isGPSEnabled = false
        var isNetworkEnabled = false
        var connectivityManager : ConnectivityManager ? =null
        var networks = ArrayList<Network>()

    }
}
