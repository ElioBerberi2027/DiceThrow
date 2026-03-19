package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

class DieFragment : Fragment() {

    private val DIESIDE = "sidenumber"
    private val DIE_ID = "die_id"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var dieId: Int = 1

    private val viewModel: DieViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            dieSides = it.getInt(DIESIDE)
            dieId = it.getInt(DIE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (dieId == 1) {
            viewModel.die1Roll.observe(viewLifecycleOwner) {
                dieTextView.text = it.toString()
            }
        } else {
            viewModel.die2Roll.observe(viewLifecycleOwner) {
                dieTextView.text = it.toString()
            }
        }
    }

    companion object {
        fun newInstance(sides: Int, id: Int) = DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE, sides)
                putInt(DIE_ID, id)
            }
        }
    }
}
