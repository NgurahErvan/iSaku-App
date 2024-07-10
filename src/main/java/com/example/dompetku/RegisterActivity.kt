package com.example.dompetku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var btnLogin: TextView
    private lateinit var inputNama: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputHp: EditText
    private lateinit var jenisKelamin: String
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnNext = findViewById(R.id.btnNext)
        inputNama = findViewById(R.id.inputNama)
        inputEmail = findViewById(R.id.inputEmail)
        inputHp = findViewById(R.id.inputHp)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }



        btnNext.setOnClickListener {
            if(inputNama.text.toString().isEmpty()) {
                inputNama.error = "Nama tidak boleh kosong"
                inputNama.requestFocus()
            } else if(inputEmail.text.toString().isEmpty()) {
                inputEmail.error = "Email tidak boleh kosong"
                inputEmail.requestFocus()
            } else if(inputHp.text.toString().isEmpty()) {
                inputHp.error = "No HP tidak boleh kosong"
                inputHp.requestFocus()
            } else {
                nextStep()
            }
        }
    }

    private fun nextStep() {
        val nama = inputNama.text.toString().trim()
        val email = inputEmail.text.toString().trim()
        val hp = inputHp.text.toString().trim()

        val bundle = Bundle()
        bundle.putString("nama", nama)
        bundle.putString("email", email)
        bundle.putString("nohp", hp)
        bundle.putString("kelamin", jenisKelamin)

        val intent = Intent(this, CreatePasswordActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}