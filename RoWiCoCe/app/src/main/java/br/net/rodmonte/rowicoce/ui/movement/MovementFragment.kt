package br.net.rodmonte.rowicoce.ui.movement

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
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
import com.faizkhan.mjpegviewer.MjpegView


class MovementFragment : Fragment() {

    private var _binding: FragmentMovementBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val TAG = "Movement Fragment"

    private val robotServiceViewModel: RobotServiceViewModel by activityViewModels()

    private var view: MjpegView? = null

    private val upCountDownTimer: CountDownTimer = object : CountDownTimer(Long.MAX_VALUE, 250) {
        override fun onTick(l: Long) {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_increase_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        override fun onFinish() {}
    }

    private val downCountDownTimer: CountDownTimer = object : CountDownTimer(Long.MAX_VALUE, 250) {
        override fun onTick(l: Long) {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.speed_decrease_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        override fun onFinish() {}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovementBinding.inflate(inflater, container, false)

        val address = robotServiceViewModel.robotService.value?.getAddress()
        val port = robotServiceViewModel.robotService.value?.getPort()?.plus(1)

        view = binding.mjpegid
        view?.isAdjustHeight = true
        view?.isAdjustWidth = true
//        view?.mode1 = MjpegView.MODE_FIT_WIDTH
        view?.setUrl("http://$address:$port/mjpeg")
        view?.isRecycleBitmap1 = true

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        view?.startStream()
    }
    override fun onPause() {
        super.onPause()
        view?.stopStream()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.increaseSpeedButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    upCountDownTimer.start()
                }
                MotionEvent.ACTION_UP -> {
                    upCountDownTimer.cancel()
                }
            }
            true
        }

        binding.decreaseSpeedButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downCountDownTimer.start()
                }
                MotionEvent.ACTION_UP -> {
                    downCountDownTimer.cancel()
                }
            }
            true
        }

        binding.buzzerButton.setOnTouchListener { _, event ->
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

        binding.forwardButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.forward_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.backwardButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.backward_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.rightButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.right_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.leftButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.left_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.stopButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.stop_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.rotateRightButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_right_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }

        binding.rotateLeftButton.setOnClickListener {
            if (robotServiceViewModel.robotService.value?.sendMessage(getString(R.string.rotate_left_pressed_message)) == false) {
                Log.w(TAG, "Message has not been sent")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}