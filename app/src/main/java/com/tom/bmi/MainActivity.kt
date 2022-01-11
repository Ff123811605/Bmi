package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun bmi(view: View) {
        val weight = binding.edWeight.text.toString().toFloat()
        val height = binding.edHeight.text.toString().toFloat()
        val bmi = weight / (height*height)

        Log.d("BMI", bmi.toString())
        //Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()

        AlertDialog.Builder(this)
            .setMessage(bmi.toString())
            .setTitle(getString(R.string.your_bmi))
            .setPositiveButton("OK", null)
            .setNeutralButton("Cancel", null)
            .show()
    }
}