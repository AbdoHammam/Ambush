package ambush

import Classes.Global
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import apps.ambush.R
class gameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        Global.getNearPlayers()

    }

}
