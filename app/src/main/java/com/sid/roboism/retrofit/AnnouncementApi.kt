package com.sid.roboism.retrofit

import com.sid.roboism.data.Announcement
import com.sid.roboism.data.CreateAnnouncementModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET


interface AnnouncementApi {
    @GET("/api/announcements")
    fun getAnnouncements(): Call<List<Announcement>>

    @POST("/api/announcements")
    fun createAnnouncement(@Body body: CreateAnnouncementModel): Call<Void>
}