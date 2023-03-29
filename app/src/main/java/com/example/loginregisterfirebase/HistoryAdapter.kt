package com.example.loginregisterfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter<T, U> : RecyclerView.Adapter<HistoryAdapter.NoteViewHolder>(){

    private var pengaduanList: ArrayList<Report> = ArrayList()
    private var onClickItem: ((Report) -> Unit)? = null
    private var onClickDeleteItem: ((Report) -> Unit)? = null


    fun addItem(items: ArrayList<Report>) {
        this.pengaduanList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (Report) -> Unit) {
        this.onClickItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_history, parent, false)
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val pengaduan = pengaduanList[position]
        holder.bindView(pengaduan)
//        holder.btnDetail.setOnClickListener { onClickItem?.invoke(pengaduan) }

    }

    override fun getItemCount(): Int {
        return pengaduanList.size
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var nama = view.findViewById<TextView>(R.id.tvNama)
        private var laporan = view.findViewById<TextView>(R.id.tvLaporan)
        private var lokasi = view.findViewById<TextView>(R.id.tvLokasi)
//        var btnDetail = view.findViewById<TextView>(R.id.btnDetail)

        fun bindView(Report: Report) {
            nama.text = Report.nama
            laporan.text = Report.isi_laporan
            lokasi.text = Report.lokasi
        }
    }

}