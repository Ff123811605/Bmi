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

//       object : View.OnClickListener() {
//           @override
//           fun OnClick(v: View) {
//           }
//       }
        binding.bHelp.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("BMI 說明")
                .setMessage(getString(R.string.help_info))
                .setPositiveButton("OK", null)
//                .setNeutralButton("Cancel", null)
                .show()
        }
        binding.bBMI.setOnClickListener {
            val weight = binding.edWeight.text.toString().toFloat()
            val height = binding.edHeight.text.toString().toFloat()
            var bmi : Float = 0f

            if (height != 0f) {
                bmi = weight / (height*height)
            } else {
                bmi = 0f
            }
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

//    fun bmi(view: View) {
//        val weight = binding.edWeight.text.toString().toFloat()
//        val height = binding.edHeight.text.toString().toFloat()
//        val bmi = weight / (height*height)
//
//        Log.d("BMI", bmi.toString())
//        //Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()
//
//        AlertDialog.Builder(this)
//            .setMessage(bmi.toString())
//            .setTitle(getString(R.string.your_bmi))
//            .setPositiveButton("OK", null)
//            .setNeutralButton("Cancel", null)
//            .show()
//   }
}