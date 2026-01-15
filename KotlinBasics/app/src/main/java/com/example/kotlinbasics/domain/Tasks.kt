package com.example.kotlinbasics.domain

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val dueDate: Long,
    val done: Boolean
)

