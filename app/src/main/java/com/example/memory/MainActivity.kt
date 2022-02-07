package com.example.memory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageButton = findViewById<Button>(R.id.btnImage)
        val saveButton = findViewById<Button>(R.id.btnSave)
        val btnChange = findViewById<Button>(R.id.btnChange)
        imageButton.setOnClickListener(View.OnClickListener{
                val intent:Intent = Intent()
                intent.setType("image/*")
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(intent,0)
        })

        saveButton.setOnClickListener{
            Toast.makeText(this@MainActivity, "저장되었습니다.", Toast.LENGTH_SHORT).show()
        }

        btnChange.setOnClickListener{
            val secondIntent=Intent(this, ScrollActivity::class.java)
            startActivity(secondIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0){
            if(resultCode == RESULT_OK){
                if (data != null) {
                    Glide.with(applicationContext).load(data.dataString).override(500).into(imageView)
                }
            }
        }
    }

}