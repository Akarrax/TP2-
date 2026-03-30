package com.example.tp2mobileservinmerlotti

import android.R.attr.type
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2mobileservinmerlotti.databinding.ActivityMainBinding
import com.example.tp2mobileservinmerlotti.databinding.ActivityResultatBinding

class ResultatActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initialiserUI()
    }

    fun initialiserUI() {

    }

    fun ilEstBon(){
        val secret = intent.getStringExtra(EXTRA_SECRET)

        if (secret!= "Bobbie"){
            binding.TextViewwiner.setText("Tu as gagné 10 $ ")
        }else{
            binding.TextViewwiner.setText("Tu dois donner 100 $ à MOI ")
        }
    }
}