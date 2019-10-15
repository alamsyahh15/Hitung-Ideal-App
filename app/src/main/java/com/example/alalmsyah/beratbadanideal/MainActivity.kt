package com.example.alalmsyah.beratbadanideal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung.setOnClickListener {
            val beratB = textBB.text.toString()
            val tinggiB = textTB.text.toString()

            if (beratB.isNotEmpty() && tinggiB.isNotEmpty()){
                //Connvert
                val con1 = beratB.toDouble()
                val con2 = tinggiB.toDouble()

                //berat badan / ((tinggi/100) kuadrat)
                val hitung = HitunIdeal(con1, con2)

                //Alert
                if (hitung < 15 ){
                    dialogAlert("$hitung" + " Kurus")
                } else if ( hitung > 23 ){
                    dialogAlert("$hitung" + " Diabetes")
                } else{
                    dialogAlert("$hitung" + " Normal")
                }




            }else{
                dialogAlert("Nilai Tidak Boleh Kosong")

            }
        }
    }
    fun HitunIdeal (berat : Double, tinggi : Double):Double{
        // Rumus
        val tinggi1 = tinggi.div(100)
        val ideal = round(berat.div(tinggi1.times(tinggi1)))
        return ideal
    }

    fun dialogAlert(msg : String){
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Berat Ideal Kamu Adalah")
        alert.setMessage(msg)
        alert.show()

    }
}
