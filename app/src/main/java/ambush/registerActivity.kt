package ambush

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import apps.ambush.R

class registerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        continButton()
    }
    fun continButton(){
        username = findViewById(R.id.nameEditText) as EditText?
        password = findViewById(R.id.passwordEditText) as EditText?
        cPassword = findViewById(R.id.confirmPasswordEditText) as EditText?
        contin = findViewById(R.id.button) as Button?
        contin!!.setOnClickListener {
            if(password!!.text.toString().equals(cPassword!!.text.toString())==false){
                Toast.makeText(this@registerActivity,"Password doesn't match", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@registerActivity, continueRegisterActivity::class.java)
                intent.putExtra("username", username!!.text.toString())
                intent.putExtra("password", password!!.text.toString())
                startActivity(intent)
            }
        }

    }
    companion object{
        private var username: EditText ?= null
        private var password: EditText ?= null
        private var cPassword: EditText ?=null
        private var contin: Button ?=null
    }
}
