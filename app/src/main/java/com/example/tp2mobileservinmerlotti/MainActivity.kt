package com.example.tp2mobileservinmerlotti

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2mobileservinmerlotti.databinding.ActivityMainBinding
import kotlin.jvm.java


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initialiserUI()
    }
    fun initialiserUI() {
        binding.buttonLancer.setOnClickListener { clickBoutonLancer() }
        binding.buttonHisto.setOnClickListener { clickBoutonHistorique() }

    }

    @SuppressLint("DiscouragedApi")
    fun clickBoutonLancer() {
        val Resulat = binding.textViewResultat.text.toString()
        val activityIntent = Intent(this, Resulat::class.java)
        val nombreR = (1..6).random()
        val resID = resources.getIdentifier("de_$nombreR", "drawable",packageName)
        binding.imageViewDe.setImageResource(resID)
        activityIntent.putExtra(EXTRA_Resulat, Resulat)

        val secretCode = binding.editTextPasswordCode.text.toString()
        if (secretCode != "") activityIntent.putExtra(EXTRA_SECRET, secretCode)

    }

    fun clickBoutonHistorique(){
        val activityIntent = Intent(this, ResultatActivity::class.java)
        startActivity(activityIntent)
    }
}