package com.example.submission_dicoding
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fish(
    val name : String,
    val description : String,
    val photo : String,
    val latin : String,
    val origin : String
) : Parcelable
