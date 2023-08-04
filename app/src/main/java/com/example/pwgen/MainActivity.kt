package com.example.pwgen

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.slider.Slider
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainlist:ListView = findViewById(R.id.main_list)
        val slider = findViewById<Slider>(R.id.slider)
        slider.addOnChangeListener { slider, value, fromUser ->
            if (value < 5) {
                slider.value = 5F
            }
        }

        val chk1 = findViewById<CheckBox>(R.id.checkBox_letters)
        val chk2 = findViewById<CheckBox>(R.id.checkBox_lettersPlus)
        val chk3 = findViewById<CheckBox>(R.id.checkBox_numbers)
        val chk4 = findViewById<CheckBox>(R.id.checkBox_specSymvol)

        val button = findViewById<Button>(R.id.button_generation)

        mainlist.setOnItemClickListener {parent, view, position, id ->
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Password", const.passwords[position])
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Текст скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            if (!chk1.isChecked && !chk2.isChecked && !chk3.isChecked && !chk4.isChecked) {
                Toast.makeText(this, "Укажите параметры", Toast.LENGTH_SHORT).show()
            }
            else {
                if (const.passwords.isEmpty()) {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, const.passwords)
                    Generate().gen(slider.value.toInt(),chk1,chk2,chk3,chk4)
                    mainlist.adapter = adapter
                    Log.d("PASSWORD", "${const.passwords.size}")
                    Toast.makeText(this, const.simvols, Toast.LENGTH_SHORT).show()
                }
                else {
                    mainlist.adapter = null
                    const.passwords.clear()
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, const.passwords)
                    Generate().gen(slider.value.toInt(),chk1,chk2,chk3,chk4)
                    mainlist.adapter = adapter
                    Log.d("PASSWORD", "${const.passwords.size}")
                    Toast.makeText(this, const.simvols, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}