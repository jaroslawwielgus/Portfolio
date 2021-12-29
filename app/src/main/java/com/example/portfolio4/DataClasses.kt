package com.example.portfolio4

data class User(val id: Int, val name: String, val surname: String,
                val email: String, val password: String, var photo: String, var my_description: String,
                var jobs: List<Job>, var universities: List<University>, var languages: List<Language>, var activities: List<Activity>)

data class Job(val id: Int, val title: String, val company: String, val description: String,
                val country: String, val town: String, val voivodeship: String)

data class University(val id: Int, val academy: String, val field_of_study: String, val description: String)

data class Language(val id: Int, val lang: String, var level: String)

data class Activity(val id: Int, val title: String, val link: String, val description: String)

