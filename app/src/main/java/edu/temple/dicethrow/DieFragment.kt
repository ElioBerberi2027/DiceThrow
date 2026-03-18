package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    private val DIESIDE = "sidenumber"
    private val ROLL_KEY = "current_role"

    lateinit var dieTextView: TextView

    var currRoll = 1
    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }

        savedInstanceState?.run {
            currRoll = getInt(ROLL_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (currRoll == 0){
            throwDie()
        }else{
            dieTextView.text = currRoll.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(ROLL_KEY, currRoll)
    }

    fun throwDie() {
        currRoll = Random.nextInt(1,dieSides + 1)
        dieTextView.text = currRoll.toString()
    }

    companion object{
        fun newInstance (sides: Int = 6) = DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE, sides)
            }
        }
    }
}
