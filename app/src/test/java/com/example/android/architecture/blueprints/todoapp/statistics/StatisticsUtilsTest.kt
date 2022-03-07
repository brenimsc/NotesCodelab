package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = true))
        val result = getActiveAndCompletedStats(tasks)
//        assertEquals(result.completedTasksPercent, 100f)
//        assertEquals(result.activeTasksPercent, 0f)

        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletStats_empty_returnZeros() {
        val tasks = listOf<Task>()
        val result = getActiveAndCompletedStats(tasks)
        if (tasks.isEmpty()) {
            assertEquals(result.activeTasksPercent, 0f)
            assertEquals(result.completedTasksPercent, 0f)
        }
    }

    @Test
    fun getQtdTaskDouble() {
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
        Task("title", "desc", isCompleted = true),
        Task("title", "desc", isCompleted = true))
        val result = getQtdTaskDoubleReal(tasks)
        assertEquals(8, result)
    }
}