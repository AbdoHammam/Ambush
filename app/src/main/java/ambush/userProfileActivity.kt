package ambush

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import apps.ambush.R

class userProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        /*username = findViewById(R.id.nameInProfile) as TextView
        username!!.text = Global.currentPlayer.name

        totalPlay = findViewById(R.id.totalPlayInProfile) as TextView
        totalPlay!!.text = "@string/total_play" + "\t" + Global.currentPlayer.totalPlay.toString()

        totalVictory = findViewById(R.id.victoryInProfile) as TextView
        totalVictory!!.text = "@string/total_victory" + "\t" + Global.currentPlayer.totalAmbushVictory.toString()

        totalDefeat = findViewById(R.id.defeatInProfile) as TextView
        totalDefeat!!.text = "@string/total_defeat" + "\t" + Global.currentPlayer.totalAmbushDefeat.toString()

        totalEscape = findViewById(R.id.escapeInProfile) as TextView
        totalEscape!!.text = "@string/total_escape" + "\t" + Global.currentPlayer.totalAmbushCounterAttackVictory.toString()

        coins = findViewById(R.id.coinsInProfile) as TextView
        coins!!.text = "@string/coins" + "\t" + Global.currentPlayer.coins.toString()

        points = findViewById(R.id.pointsInProfile) as TextView
        points!!.text = "@string/points" + "\t" + Global.currentPlayer.points.toString()*/
        val buttonLoadImage = findViewById(R.id.uploadImageButton) as Button
        buttonLoadImage.setOnClickListener( {
                val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(i, RESULT_LOAD_IMAGE)
        })

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

            val cursor = contentResolver.query(selectedImage,
                    filePathColumn, null, null, null)
            cursor.moveToFirst()

            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            cursor.close()

            val imageView = findViewById(R.id.profilePicture) as ImageView
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath))

        }


    }
    companion object {
        var username : TextView ?= null
        var totalPlay : TextView ?= null
        var totalVictory : TextView ?= null
        var totalDefeat : TextView ?= null
        var totalEscape : TextView ?= null
        var coins : TextView ?= null
        var points : TextView ?= null
        var RESULT_LOAD_IMAGE =1
    }
}
