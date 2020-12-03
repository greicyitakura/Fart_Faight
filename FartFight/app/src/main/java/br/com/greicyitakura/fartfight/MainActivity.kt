package br.com.greicyitakura.fartfight

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btngangster.setOnClickListener {
            tvResult.text = joga(0)
        }
        btnhacker.setOnClickListener {
            tvResult.text = joga(1)
        }
        btnnerd.setOnClickListener {
            tvResult.text = joga(2)
        }
    }
    private fun joga(num: Int) : String {
        ivComp.visibility = View.VISIBLE
        val comp = Random.nextInt(3)
        var end: String = ""

        when (comp){
            0 -> ivComp.setImageDrawable(getDrawable(R.drawable.gangster))
            1 -> ivComp.setImageDrawable(getDrawable(R.drawable.hacker))
            2 -> ivComp.setImageDrawable(getDrawable(R.drawable.nerd))
        }
        if (comp == num){
            end = "Deu Empate"
            tvResult.setTextColor(Color.GRAY)
            Handler(Looper.getMainLooper()).postDelayed({
                val mIntent = Intent(this, MainActivity::class.java)
                startActivity(mIntent)
                finish()
            }, 1500)

        }
        else if ((comp == 0 && num == 1) || (comp == 1 && num == 2) || (comp == 2 && num == 0)){
            end = "Você Perdeu"
            tvResult.setTextColor(Color.RED)
            Handler(Looper.getMainLooper()).postDelayed({
                val mIntent = Intent(this, MainActivity::class.java)
                startActivity(mIntent)
                finish()
            }, 1500)


        }
        else {
            end = "Você Ganhou"
            tvResult.setTextColor(Color.GREEN)
            Handler(Looper.getMainLooper()).postDelayed({
                val mIntent = Intent(this, MainActivity::class.java)
                startActivity(mIntent)
                finish()
            }, 1500)

        }
        return end
    }
}