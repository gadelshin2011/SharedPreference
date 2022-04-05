package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var btnClear: Button
    val SharedPreference: SharedPreference = SharedPreference(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()

    }

    private fun setListener() {
        binding.btnSave.setOnClickListener {
            val edtName = binding.editName.text.toString()
            val edtEmail = binding.editEmail.text.toString()
            SharedPreference.saveString("name", edtName)
            SharedPreference.saveString("email", edtEmail)
            Toast.makeText(this@MainActivity, "Data Stored", Toast.LENGTH_SHORT).show()


        }

        binding.btnClear.setOnClickListener {
            if (SharedPreference.getValueString("name") != null) {
                edtName.hint = SharedPreference.getValueString("name")!!
                Toast.makeText(this@MainActivity, "Data Retrieved", Toast.LENGTH_SHORT).show()
            } else {
                edtName.hint = "No value found"
            }
            if (SharedPreference.getValueString("") != null) {
                edtName.hint = SharedPreference.getValueString("email")!!
                Toast.makeText(this@MainActivity, "Data Retrieved", Toast.LENGTH_SHORT).show()
            } else {
                edtName.hint = "No value found"
            }
        }

        btnClear.setOnClickListener {
            SharedPreference.clearSharedPreference()
            Toast.makeText(this@MainActivity,"Data Cleared",Toast.LENGTH_SHORT).show()
        }


    }


}