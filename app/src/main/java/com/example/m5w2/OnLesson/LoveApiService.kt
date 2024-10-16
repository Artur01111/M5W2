package com.example.m5w2.OnLesson

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {

    //CRUD -
    //C - CREATE - POST
    //R - READ - GET
    //U - UPDATE - PUT, POST
    //D - DELETE
    //https://online.geeks.kg/ - base url
    //https://online.geeks.kg/homework/80fe2274-d059-43f7-a8f1-75ec82c0a2d1 - endpoint / method

    //https://online.geeks.kg/
    //https://online.geeks.kg/homework/
    //Query params =  ?name=Alice&fname=John
    //Header = x-rapidapi-key - 13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c
    //Header = x-rapidapi-host - love-calculator.p.rapidapi.com/

    @GET("GetPercentage")
    fun fetchPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-rapidapi-key") key : String,
        @Header("X-rapidapi-host") host: String
    ): Call<PercentageResponse>
}