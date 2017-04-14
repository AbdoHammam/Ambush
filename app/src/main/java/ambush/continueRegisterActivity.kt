package ambush

import Classes.Global
import Classes.RegisterRequest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import apps.ambush.R

class continueRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cont_register)
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")
        var text = findViewById(R.id.victory_insult) as EditText?
        val victoryInsult = text!!.text.toString()
        text = findViewById(R.id.editText) as EditText?
        val escapeInsult = text!!.text.toString()
        text = findViewById(R.id.editText4) as EditText?
        val counterAttackInsult = text!!.text.toString()
        val completeButton = findViewById(R.id.button2)
        completeButton!!.setOnClickListener {

            var registerUser : RegisterRequest = RegisterRequest()
            registerUser.username = username
            registerUser.password = password
            registerUser.ambushVictory = victoryInsult
            registerUser.ambushCounterAttackVictory = counterAttackInsult
            registerUser.ambushEscape = escapeInsult
            var done : Boolean = Global.Register(registerUser)
            if(done) {
                Toast.makeText(this@continueRegisterActivity,"Registration successfully completed",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@continueRegisterActivity,loginActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@continueRegisterActivity,"There's another player with the same name",Toast.LENGTH_SHORT).show()
            }


        }

    }
}
