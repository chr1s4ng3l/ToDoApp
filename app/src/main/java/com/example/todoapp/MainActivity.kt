package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private val mAdapter: Adapter by lazy {
        Adapter(
            com.example.todoapp.List.addI(binding.txtInput.text.toString())

        ) {
            Toast.makeText(this, "Here ${it.item}", Toast.LENGTH_SHORT).show()
        }
    }


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


            binding.btnAdd.setOnClickListener {
                binding.rv.apply {
                    layoutManager = LinearLayoutManager(
                        this@MainActivity, LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter = mAdapter
                    mAdapter.updateItems(com.example.todoapp.List.addI(binding.txtInput.text.toString()))

                }

                }
            }


    }

