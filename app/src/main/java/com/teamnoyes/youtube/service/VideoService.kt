package com.teamnoyes.youtube.service

import com.teamnoyes.youtube.dto.VideoDto
import retrofit2.Call
import retrofit2.http.GET

interface VideoService {
    @GET("/v3/fdb646ed-e6de-4d7d-b228-12d2b6d08b22")
    fun listVideos(): Call<VideoDto>
}