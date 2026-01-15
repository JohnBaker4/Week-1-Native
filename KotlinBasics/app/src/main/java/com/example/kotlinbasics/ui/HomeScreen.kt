package com.example.kotlinbasics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinbasics.domain.Task
import com.example.kotlinbasics.domain.addTask
import com.example.kotlinbasics.domain.toggleDone

@Composable
fun HomeScreen(initialTasks: List<Task>) {
    var tasks by remember { mutableStateOf(initialTasks) }
    var newTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "My Tasks",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        tasks.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = task.title)

                Button(onClick = {
                    tasks = toggleDone(tasks, task.id)
                }) {
                    Text(if (task.done) "Done" else "Mark done")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = newTitle,
            onValueChange = { newTitle = it },
            label = { Text("Task title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (newTitle.isNotBlank()) {
                    val newTask = Task(
                        id = tasks.size + 1,
                        title = newTitle,
                        description = "",
                        priority = 1,
                        dueDate = System.currentTimeMillis(),
                        done = false
                    )
                    tasks = addTask(tasks, newTask)
                    newTitle = ""
                }
            }
        ) {
            Text("Add task")
        }
    }
}
