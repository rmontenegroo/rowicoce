package br.net.rodmonte.rowicoce

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.net.rodmonte.rowicoce.databinding.ActivityMainBinding

class RobotServiceViewModel : ViewModel() {
    private val mutableRobotService = MutableLiveData<RobotService>()
    val robotService: LiveData<RobotService> get() = mutableRobotService

    fun setRobotService(robotService: RobotService) {
        mutableRobotService.value = robotService
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val robotServiceViewModel: RobotServiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_setup, R.id.navigation_movement, R.id.navigation_custom
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        robotServiceViewModel.robotService.observe(this) { item ->
            Log.w("MainActivity", item.toString())
        }

        /*
            Adicionado para não ocorrer erro ao fazer conexão via socket
         */
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }
}