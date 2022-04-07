package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp = getSharedPreferences("data_storage", Context.MODE_PRIVATE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        binding.btnSave.setOnClickListener {
            sp.edit().putString("name", binding.editName.text.toString()).apply()
            sp.edit().putString("email", binding.editEmail.text.toString()).apply()
            Toast.makeText(this@MainActivity, "Data Stored", Toast.LENGTH_SHORT).show()
        }

        binding.btnRetrive.setOnClickListener {
            binding.editName.hint = sp.getString("name", "")
            binding.editEmail.hint = sp.getString("email", "")
            Toast.makeText(this@MainActivity, "Data Retrieved", Toast.LENGTH_SHORT).show()
        }

        binding.btnClear.setOnClickListener {
            sp.edit().clear().apply()
            Toast.makeText(this@MainActivity, "Data Cleared", Toast.LENGTH_SHORT).show()
        }


    }


}