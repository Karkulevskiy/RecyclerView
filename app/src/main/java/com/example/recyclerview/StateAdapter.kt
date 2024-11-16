package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class State(val name: String, val company: String, val flagResource : Int)

// Адаптер
class StateAdapter(
    private val ctx: Context,
    private val states: List<State>)
    : RecyclerView.Adapter<StateAdapter.ViewHolder>() {

        // View Holder, конструктор принимает имя языка программирования, его компанию а также картинку
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.name)
        val logoView: ImageView = view.findViewById(R.id.logo)
        val companyView: TextView = view.findViewById(R.id.company)
    }

    // Создание ViewHolder'а
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(this.ctx).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = states.size

    // Последняя выбранная позиция пользователем
    private var selectedPosition: Int = RecyclerView.NO_POSITION

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Получаем выбранные объект
        val state = states[position]

        // Меняем ему прозрачность
        holder.logoView.alpha = if (position == selectedPosition) 0.5f else 1.0f

        // обновляем holder
        holder.logoView.setImageResource(state.flagResource)
        holder.nameView.text = state.name
        holder.companyView.text = state.company

        // по клику
        holder.itemView.setOnClickListener {
            // обновляем последнюю выбранную позицию
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition

            // сообщаем адаптеру
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)

            // выводим уведомление о выбранном языке программирования
            Toast.makeText(ctx, "Your choice is: " + state.name, Toast.LENGTH_SHORT).show()
        }
    }
}