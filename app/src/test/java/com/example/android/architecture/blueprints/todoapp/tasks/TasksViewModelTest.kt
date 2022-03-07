package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var taskViewModel: TasksViewModel

    @Before //para usar a mesma variavel em varios lugares
    fun setupViewModel() {
        taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext()) //pegando o contexto
    }

    @Test
    fun addNewTask_setsNewTaskEvent() {
        taskViewModel.addNewTask()

        val value = taskViewModel.newTaskEvent.getOrAwaitValue() //metodo que observa forever e remove o observador
        assertThat(value.getContentIfNotHandled(), (not(nullValue()))) // compara se o valor náo e null
        //assertEquals(value.getContentIfNotHandled(), notNullValue())

    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {
        taskViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        val value = taskViewModel.tasksAddViewVisible.getOrAwaitValue()

        //assertThat(value, `is`(true))
        assertEquals(true, value)
    }
}