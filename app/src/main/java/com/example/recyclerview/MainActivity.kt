package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    // Объекты, которые можно выбрать
    private var states = ArrayList<State>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        // инициализируем объекты
        initializeStates()

        // создаем адаптер
        val adapter = StateAdapter(this, states)

        // Создаем RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.list)

        // Ставим адаптер
        recyclerView.setAdapter(adapter)
    }

    // Исходные объекты
    private fun initializeStates(){
        states.add(State("Golang", "Google", R.drawable.go))
        states.add(State("C", "Community", R.drawable.c))
        states.add(State("C#", "Microsoft", R.drawable.c_sharp))
        states.add(State("Python", "PSF", R.drawable.python))
        states.add(State("Kotlin", "JetBrains", R.drawable.kotlin))
    }
}