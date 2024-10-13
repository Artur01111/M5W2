package com.example.m5w2.OnLesson

class Person (
    val name: String,
    val lastName:String,
    val dateOfBirth: String,
    val height: Int,
    val weight: Int,
    val address: String,
    val sex: String,
    val job: Job
)

class Job(
    val name: String,
    val address: String,
    val schedule: String,
    val salary: Int,
    val nameOfCollege: List<String>
)