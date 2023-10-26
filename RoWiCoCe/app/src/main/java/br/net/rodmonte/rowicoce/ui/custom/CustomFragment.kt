package br.net.rodmonte.rowicoce.ui.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.net.rodmonte.rowicoce.RobotServiceViewModel
import br.net.rodmonte.rowicoce.databinding.FragmentCustomBinding
import android.util.Log
import androidx.core.widget.doAfterTextChanged

class CustomFragment : Fragment() {

    private var _binding: FragmentCustomBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val TAG = "Custom Fragment"

    private val robotServiceViewModel: RobotServiceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.custom1Text.doAfterTextChanged { text ->
            binding.custom1Button.isEnabled = text.toString() != ""
        }

        binding.custom2Text.doAfterTextChanged { text ->
            binding.custom2Button.isEnabled = text.toString() != ""
        }

        binding.custom3Text.doAfterTextChanged { text ->
            binding.custom3Button.isEnabled = text.toString() != ""
        }

        binding.custom4Text.doAfterTextChanged { text ->
            binding.custom4Button.isEnabled = text.toString() != ""
        }

        binding.custom5Text.doAfterTextChanged { text ->
            binding.custom5Button.isEnabled = text.toString() != ""
        }

        binding.custom6Text.doAfterTextChanged { text ->
            binding.custom6Button.isEnabled = text.toString() != ""
        }

        binding.custom7Text.doAfterTextChanged { text ->
            binding.custom7Button.isEnabled = text.toString() != ""
        }

        binding.custom8Text.doAfterTextChanged { text ->
            binding.custom8Button.isEnabled = text.toString() != ""
        }

        binding.custom9Text.doAfterTextChanged { text ->
            binding.custom9Button.isEnabled = text.toString() != ""
        }

        binding.custom10Text.doAfterTextChanged { text ->
            binding.custom10Button.isEnabled = text.toString() != ""
        }

        binding.custom1Button.setOnClickListener {
            val message : String = binding.custom1Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom2Button.setOnClickListener {
            val message : String = binding.custom2Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom3Button.setOnClickListener {
            val message : String = binding.custom3Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom4Button.setOnClickListener {
            val message : String = binding.custom4Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom5Button.setOnClickListener {
            val message : String = binding.custom5Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom6Button.setOnClickListener {
            val message : String = binding.custom6Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom7Button.setOnClickListener {
            val message : String = binding.custom7Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom8Button.setOnClickListener {
            val message : String = binding.custom8Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom9Button.setOnClickListener {
            val message : String = binding.custom9Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }

        binding.custom10Button.setOnClickListener {
            val message : String = binding.custom10Text.text.toString()
            if (message != "") {
                if (robotServiceViewModel.robotService.value?.sendMessage(message) == false) {
                    Log.w(TAG, "Message has not been sent")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}