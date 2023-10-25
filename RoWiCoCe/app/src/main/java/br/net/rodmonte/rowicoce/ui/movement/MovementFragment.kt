package br.net.rodmonte.rowicoce.ui.movement

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.net.rodmonte.rowicoce.R
import br.net.rodmonte.rowicoce.databinding.FragmentMovementBinding

class MovementFragment : Fragment() {

    private var _binding: FragmentMovementBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val TAG = "Movement Fragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovementBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.forwardButton.setOnTouchListener { v, event ->
            Log.w(TAG, v.toString())
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.forwardButton.setImageResource(R.drawable.arrow_up_pressed)
                }
                MotionEvent.ACTION_UP -> {
                    binding.forwardButton.setImageResource(R.drawable.arrow_up)
                }
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}