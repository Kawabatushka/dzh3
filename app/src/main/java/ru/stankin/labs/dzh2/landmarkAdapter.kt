package ru.stankin.labs.dzh2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/**
 * Адаптер для RecyclerView.
 * Конструктор принимает список контактов.
 * Наследуемся от RecyclerView.Adapter и переопределяем
 * необходимые методы.
 */
class landmarksAdapter(
    private val contracts: List<landmarkItem>,
    private val onItemClicked: (item: landmarkItem) -> Unit,
): RecyclerView.Adapter<landmarkViewHolder>() {
    private fun onViewHolderClicked(position: Int) {
        onItemClicked(contracts[position])
    }
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): landmarkViewHolder {
        // создание View из макета для ViewHolder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.landmark_item, parent, false)
        return landmarkViewHolder(view, this::onViewHolderClicked)
    }
    /**
     * Кол-во элементов в адаптере (списке)
     */
    override fun getItemCount(): Int {
        return contracts.size
    }
    /**
     * Добавление данных на соответсвующий ViewHolder.
     */
    override fun onBindViewHolder(
        holder: landmarkViewHolder, position: Int
    ) {
        holder.bind(contracts[position])
    }
}
/**
 * ViewHolder элемента списка.
 * Наследуемся от RecyclerView.ViewHolder
 */
class landmarkViewHolder(
    itemView: View,
    private val onItemClicked: (position: Int) -> Unit
): RecyclerView.ViewHolder(itemView) {
    private val nameView: TextView = itemView.findViewById(R.id.landmark_name)
    private val infoView: TextView = itemView.findViewById(R.id.landmark_info)

    init {
        itemView.setOnClickListener { onItemClicked(adapterPosition) }
    }

    /**
     * Метод для связывания данных с ViewHolder
     */
    fun bind(item: landmarkItem) {
        nameView.text = item.name
        infoView.text = "${item.country}, ${item.city}, age: ~${item.estimatedAgeYears} years"
    }
}