package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseapp.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class CadastroActivity : AppCompatActivity() {

    private val binding: ActivityCadastroBinding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            buttonLogar.setOnClickListener {
                val user = editUser.text.toString()
                val email = editEmail.text.toString()
                val senha = editSenha.text.toString()
                val confirmarSenha = editConfirmSenha.text.toString()
                validateData(user,email,senha,confirmarSenha)
            }

        }
    }

    private fun validateData(user: String, email: String, senha: String, confirmarSenha: String) {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,}")

        if(user.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && confirmarSenha.isNotEmpty()){
            if (!emailRegex.matches(email)) {
                exibeToast("Email inválido,")
            } else if (senha.length < 6) {
                exibeToast("Senha inválida,")
            } else if(senha != confirmarSenha){
                exibeToast("Senhas diferentes,")
            }
            else {
                initCadastro(email,senha)
            }
        }else{
            exibeToast("Existe algum campo vazio,")
        }
    }

    private fun initCadastro(email: String, senha: String) {
        auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if(it.isSuccessful){
                startActivity(Intent(this@CadastroActivity,LoginActivity::class.java))
            }else{
                exibeToast(it.exception.toString())
            }
        }
    }


    private fun exibeToast(erro: String) {
        Toast.makeText(this,"$erro tente novamente!",Toast.LENGTH_LONG).show()
    }
}