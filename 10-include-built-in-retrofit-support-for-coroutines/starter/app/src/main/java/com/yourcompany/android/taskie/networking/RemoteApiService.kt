package com.yourcompany.android.taskie.networking

import com.yourcompany.android.taskie.model.DeleteNoteResponse
import com.yourcompany.android.taskie.model.Task
import com.yourcompany.android.taskie.model.request.AddTaskRequest
import com.yourcompany.android.taskie.model.request.UserDataRequest
import com.yourcompany.android.taskie.model.response.CompleteNoteResponse
import com.yourcompany.android.taskie.model.response.GetTasksResponse
import com.yourcompany.android.taskie.model.response.LoginResponse
import com.yourcompany.android.taskie.model.response.RegisterResponse
import com.yourcompany.android.taskie.model.response.UserProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Holds the API calls for the Taskie app.
 */
interface RemoteApiService {

  @POST("/api/register")
  fun registerUser(@Body request: UserDataRequest): Call<RegisterResponse>

  @GET("/api/note")
  fun getNotes(): Call<GetTasksResponse>

  @POST("/api/login")
  fun loginUser(@Body request: UserDataRequest): Call<LoginResponse>

  @GET("/api/user/profile")
  fun getMyProfile(): Call<UserProfileResponse>

  @POST("/api/note/complete")
  fun completeTask(
      @Query("id") noteId: String): Call<CompleteNoteResponse>

  @POST("/api/note")
  fun addTask(
      @Body request: AddTaskRequest): Call<Task>

  @DELETE("/api/note")
  fun deleteNote(@Query("id") noteId: String): Call<DeleteNoteResponse>
}