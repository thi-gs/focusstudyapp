package com.example.studytimer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studytimer.R
import com.example.studytimer.model.Session

class SessionAdapter(private val sessions: List<Session>) :
    RecyclerView.Adapter<SessionAdapter.SessionViewHolder>() {

    class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvSessionTitle)
        val tvDuration: TextView = itemView.findViewById(R.id.tvSessionDuration)
        val tvDate: TextView = itemView.findViewById(R.id.tvSessionDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_session, parent, false)
        return SessionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val session = sessions[position]
        holder.tvTitle.text = session.title
        holder.tvDuration.text = "${session.durationMinutes} minutos"
        holder.tvDate.text = session.date
    }

    override fun getItemCount(): Int = sessions.size
}
