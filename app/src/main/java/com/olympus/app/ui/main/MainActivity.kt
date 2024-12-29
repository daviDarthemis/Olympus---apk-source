
package com.olympus.app.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olympus.app.databinding.ActivityMainBinding


/**
 * @author JoseG-asm 
 */
public class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
      get() = binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
