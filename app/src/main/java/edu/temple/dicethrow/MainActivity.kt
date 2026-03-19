package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: DieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(20, 1))
                .add(R.id.fragmentContainerView2, DieFragment.newInstance(6, 2))
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            viewModel.rollDie(20)
            viewModel.rollDie2(6)
        }
    }
}