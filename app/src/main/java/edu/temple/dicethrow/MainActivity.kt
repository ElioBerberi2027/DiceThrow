package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(6)) // first die
                .commit()
        }

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView2, DieFragment.newInstance(20)) // second die
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            listOf(R.id.fragmentContainerView, R.id.fragmentContainerView2).forEach { id ->
                supportFragmentManager.findFragmentById(id)?.run {
                    (this as DieFragment).throwDie()
                }
            }
        }
    }
}