package br.net.rodmonte.rowicoce.ui.setup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import br.net.rodmonte.rowicoce.RobotService
import br.net.rodmonte.rowicoce.RobotServiceViewModel
import br.net.rodmonte.rowicoce.databinding.FragmentSetupBinding

class SetupFragment : Fragment() {

    private val TAG = "SetupFragment"

    private var _binding: FragmentSetupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val robotServiceViewModel: RobotServiceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetupBinding.inflate(inflater, container, false)
        val root: View = binding.root

        robotServiceViewModel.setRobotService(RobotService(binding.editTextAddress.text.toString(), binding.editTextPort.text.toString().toInt()))

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextAddress.doAfterTextChanged {
            try {
                robotServiceViewModel.setRobotService(RobotService(binding.editTextAddress.text.toString(), binding.editTextPort.text.toString().toInt()))
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }

        binding.editTextPort.doAfterTextChanged {
            try {
                robotServiceViewModel.setRobotService(RobotService(binding.editTextAddress.text.toString(), binding.editTextPort.text.toString().toInt()))
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }

        binding.buttonTestConnection.setOnClickListener {

            binding.buttonTestConnection.isClickable = false

            var message: String = "Connection failed!"

            if (robotServiceViewModel.robotService.value?.testConnection() == true){
                message = "Connection succeeded!"
            }

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

            binding.buttonTestConnection.isClickable = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}