package br.net.rodmonte.rowicoce.ui.setup

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.net.rodmonte.rowicoce.RobotService
import br.net.rodmonte.rowicoce.RobotServiceViewModel
import br.net.rodmonte.rowicoce.databinding.FragmentSetupBinding

class SetupFragment : Fragment() {

    private val TAG = "Setup Fragment"

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

        var useAddress = binding.editTextAddress.text.toString()
        var usePort = binding.editTextPort.text.toString().toInt()

        val sharedPref :SharedPreferences? = this.activity?.getSharedPreferences("br.net.rodmonte.rowicoce.preferences", Context.MODE_PRIVATE)
        if (sharedPref != null) {
            useAddress = sharedPref.getString("connection_address_key", useAddress) as String
            usePort = sharedPref.getInt("connection_port_key", usePort)
        }

        binding.editTextAddress.setText(useAddress)
        binding.editTextPort.setText(usePort.toString())
        robotServiceViewModel.setRobotService(RobotService(useAddress, usePort))

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveConnectionDataButton.setOnClickListener {
            val address = binding.editTextAddress.text.toString()
            val port = binding.editTextPort.text.toString().toInt()

            val sharedPref :SharedPreferences? = this.activity?.getSharedPreferences("br.net.rodmonte.rowicoce.preferences", Context.MODE_PRIVATE)

            if (sharedPref == null) {
                Toast.makeText(context, "An error has occurred saving data", Toast.LENGTH_SHORT).show()
            } else {
                with (sharedPref.edit()) {
                    this.putString("connection_address_key", address)
                    this.putInt("connection_port_key", port)
                    this.apply()
                }
                Toast.makeText(context, "Data has been saved", Toast.LENGTH_SHORT).show()
            }
        }

        binding.editTextAddress.doAfterTextChanged {
            binding.saveConnectionDataButton.isEnabled =
                binding.editTextAddress.text.toString() != ""
            binding.buttonTestConnection.isEnabled =
                binding.editTextAddress.text.toString() != ""
            try {
                robotServiceViewModel.setRobotService(RobotService(binding.editTextAddress.text.toString(), binding.editTextPort.text.toString().toInt()))
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }

        binding.editTextPort.doAfterTextChanged {
            binding.saveConnectionDataButton.isEnabled = binding.editTextPort.text.toString() != ""
            binding.buttonTestConnection.isEnabled = binding.editTextPort.text.toString() != ""
            try {
                robotServiceViewModel.setRobotService(RobotService(binding.editTextAddress.text.toString(), binding.editTextPort.text.toString().toInt()))
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }

        binding.buttonTestConnection.setOnClickListener {

            binding.buttonTestConnection.isClickable = false

            var message = "Connection failed!"

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