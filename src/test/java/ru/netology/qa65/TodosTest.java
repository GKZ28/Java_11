package ru.netology.qa65;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask1 = new SimpleTask(6, "Позвонить детям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(

            555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

    Todos todos = new Todos();


    @Test
    public void shouldAddThreeTasksOfDifferentType() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void matchesTest() {

        assertTrue(meeting.matches("Выкатка"));
        assertFalse(meeting.matches("бочка"));
        assertTrue(simpleTask.matches("Позвонить"));
        assertFalse(simpleTask.matches("Трубка"));
        assertTrue(epic.matches("Молоко"));
        assertFalse(epic.matches("Задача"));

    }


    @Test
    public void searchTestFoundOneResult() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Яйца");  // если запрос находит
        Task[] expected = {epic};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestNotFoundResult() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Кефир");   // если запрос не находит
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchTestFoundFewResults() {
        todos.add(simpleTask);
        todos.add(simpleTask1);

        Task[] actual = todos.search("Позвонить");
        Task[] expected = {simpleTask, simpleTask1};
        Assertions.assertArrayEquals(expected, actual);
    }

}