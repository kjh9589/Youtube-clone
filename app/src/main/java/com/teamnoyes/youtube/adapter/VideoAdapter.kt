package com.teamnoyes.youtube.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnoyes.youtube.R
import com.teamnoyes.youtube.model.VideoModel

class VideoAdapter(private val callback: (String, String) -> Unit): ListAdapter<VideoModel, VideoAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(videoModel: VideoModel){
            val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
            val subTitleTextView = view.findViewById<TextView>(R.id.subTitleTextView)
            val thumbnailImageView = view.findViewById<ImageView>(R.id.thumbnailImageView)

            titleTextView.text = videoModel.title
            subTitleTextView.text = videoModel.subtitle
            println(videoModel.thumb)
            Glide.with(thumbnailImageView)
                .load(videoModel.thumb)
                .into(thumbnailImageView)

            view.setOnClickListener {
                callback(videoModel.sources, videoModel.title)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_video,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: VideoAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<VideoModel>() {
            override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                // 고유 아이템이 없음
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}