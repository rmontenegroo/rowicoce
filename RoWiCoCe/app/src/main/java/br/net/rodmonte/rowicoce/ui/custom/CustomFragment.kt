package br.net.rodmonte.rowicoce.ui.custom

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.net.rodmonte.rowicoce.RobotServiceViewModel
import br.net.rodmonte.rowicoce.databinding.FragmentCustomBinding
import android.util.Log
import android.widget.Toast
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

        var custom1 = "custom1"
        var custom2 = "custom2"
        var custom3 = "custom3"
        var custom4 = "custom4"
        var custom5 = "custom5"
        var custom6 = "custom6"

        val sharedPref :SharedPreferences? = this.activity?.getSharedPreferences("br.net.rodmonte.rowicoce.preferences", Context.MODE_PRIVATE)

        if (sharedPref != null) {
            custom1 = sharedPref.getString("custom1_key", custom1) as String
            custom2 = sharedPref.getString("custom2_key", custom2) as String
            custom3 = sharedPref.getString("custom3_key", custom3) as String
            custom4 = sharedPref.getString("custom4_key", custom4) as String
            custom5 = sharedPref.getString("custom5_key", custom5) as String
            custom6 = sharedPref.getString("custom6_key", custom6) as String
        }

        binding.custom1Text.setText(custom1)
        binding.custom2Text.setText(custom2)
        binding.custom3Text.setText(custom3)
        binding.custom4Text.setText(custom4)
        binding.custom5Text.setText(custom5)
        binding.custom6Text.setText(custom6)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveCustomCommandsButton.setOnClickListener {
            val custom1 = binding.custom1Text.text.toString()
            val custom2 = binding.custom2Text.text.toString()
            val custom3 = binding.custom3Text.text.toString()
            val custom4 = binding.custom4Text.text.toString()
            val custom5 = binding.custom5Text.text.toString()
            val custom6 = binding.custom6Text.text.toString()

            val sharedPref : SharedPreferences? = this.activity?.getSharedPreferences("br.net.rodmonte.rowicoce.preferences", Context.MODE_PRIVATE)

            if (sharedPref == null) {
                Toast.makeText(context, "An error has occurred saving data", Toast.LENGTH_SHORT).show()
            } else {
                with (sharedPref.edit()) {
                    this.putString("custom1_key", custom1)
                    this.putString("custom2_key", custom2)
                    this.putString("custom3_key", custom3)
                    this.putString("custom4_key", custom4)
                    this.putString("custom5_key", custom5)
                    this.putString("custom6_key", custom6)
                    this.apply()
                }
                Toast.makeText(context, "Data has been saved", Toast.LENGTH_SHORT).show()
            }
        }

        binding.custom1Text.doAfterTextChanged { text ->
            binding.custom1Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
        }

        binding.custom2Text.doAfterTextChanged { text ->
            binding.custom2Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
        }

        binding.custom3Text.doAfterTextChanged { text ->
            binding.custom3Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
        }

        binding.custom4Text.doAfterTextChanged { text ->
            binding.custom4Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
        }

        binding.custom5Text.doAfterTextChanged { text ->
            binding.custom5Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
        }

        binding.custom6Text.doAfterTextChanged { text ->
            binding.custom6Button.isEnabled = text.toString() != ""
            binding.saveCustomCommandsButton.isEnabled = text.toString() != ""
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}