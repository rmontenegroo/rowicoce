package br.net.rodmonte.rowicoce.ui.movement

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.net.rodmonte.rowicoce.R
import br.net.rodmonte.rowicoce.RobotServiceViewModel
import br.net.rodmonte.rowicoce.databinding.FragmentMovementBinding

class MovementFragment : Fragment() {

    private var _binding: FragmentMovementBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val TAG = "Movement Fragment"

    private val robotServiceViewModel: RobotServiceViewModel by activityViewModels()

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

        binding.increaseSpeedButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_increase_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_increase_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.decreaseSpeedButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_decrease_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_decrease_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.buzzerButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.buzzer_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.buzzer_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.forwardButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.forward_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.forward_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.backwardButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.backward_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.backward_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.rightButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.right_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.right_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.leftButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.left_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.left_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.stopButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.stop_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.stop_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.rotateRightButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_right_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_right_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
            }
            true
        }

        binding.rotateLeftButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_left_pressed_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_left_released_message)) == false) {
                        Log.w(TAG, "Message has not been sent")
                    }
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