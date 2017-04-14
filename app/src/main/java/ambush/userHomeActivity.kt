package ambush

import Classes.Global
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import apps.ambush.R

class userHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        Buttons()
    }
    fun Buttons()
    {
        startGame = findViewById(R.id.SGame) as Button?
        multiGame = findViewById(R.id.multiGame) as Button?
        scoreBoard = findViewById(R.id.SBoard) as Button?
        newWeapon = findViewById(R.id.GetWeapon) as Button?
        exit = findViewById(R.id.Exit) as Button?
        startGame!!.setOnClickListener {
            val intent = Intent(this@userHomeActivity, gameActivity::class.java)
            startActivity(intent)
        }
        multiGame!!.setOnClickListener {
            val intent = Intent(this@userHomeActivity, gangActivity::class.java)
            startActivity(intent)
        }
        scoreBoard!!.setOnClickListener {
            val intent = Intent(this@userHomeActivity, scoreboardActivity::class.java)
            startActivity(intent)
        }
        newWeapon!!.setOnClickListener {
            val intent = Intent(this@userHomeActivity, weaponsActivity::class.java)
            startActivity(intent)
        }

        exit!!.setOnClickListener {
            //System.exit(0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.profile) {
            var intent = Intent(this@userHomeActivity, userProfileActivity::class.java)
            startActivity(intent)
            return true
        }
        else if(id==R.id.logout) {
            var intent = Intent(this@userHomeActivity,loginActivity::class.java)
            Global.currentPlayer != null
            startActivity(intent)
            return true
        }
        else if(id==R.id.coinsInMenu){
            var alert: AlertDialog.Builder = AlertDialog.Builder(this)
            alert.setView(R.layout.choose_weapon_dialog)
            alert.setTitle("Convert from points to coins | 1 coin = 10 points")
            alert.show()
            var text : EditText = findViewById(R.id.numOfCoinsInChooseWeaponDialog) as EditText
            var coins :Int = text!!.text.toString().toInt()
            val btn : Button = findViewById(R.id.addCoinsInChooseWeaponDialog) as Button
            btn.setOnClickListener {
                if(coins <= Global.currentPlayer.points/10){
                    Global.currentPlayer.coins += coins
                    Global.currentPlayer.points -= coins*10
                    Toast.makeText(this@userHomeActivity,"Added successfully",Toast.LENGTH_SHORT).show()
                    // Update User
                }
                else
                    Toast.makeText(this@userHomeActivity,"You don't have enough points",Toast.LENGTH_SHORT).show()
            }


        }

        return super.onOptionsItemSelected(item)
    }
    companion object {
        private var startGame: Button? = null
        private var scoreBoard: Button? = null
        private var newWeapon: Button? = null
        private var multiGame : Button?= null
        private var exit: Button ? = null
    }
}
