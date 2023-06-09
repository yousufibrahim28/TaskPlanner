package com.yousufibrahim28.TaskPlanner.Task;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TaskService {
    private static List<Task> tasks;

    private static int taskCount = 0;
    static {
        tasks  = new ArrayList<>();
        tasks.add(new Task(++taskCount, "yousuf28","Learn SpringBoot",
                LocalDate.now().plusYears(1),false));
        tasks.add(new Task(++taskCount, "yousuf28","Learn AWS",
                LocalDate.now().plusYears(2),false));
        tasks.add(new Task(++taskCount, "yousuf28","Learn Docker",
                LocalDate.now().plusYears(3),false));
    }

    public List<Task> findByUsername(String username) {
        Predicate<? super Task> predicate = task -> task.getUsername().equalsIgnoreCase(username);
        return tasks.stream().filter(predicate).toList();
    }

    public void addTask(String username, String description, LocalDate targetDate, boolean isDone) {
        Task task = new Task(++taskCount,username,description,targetDate,isDone);
        tasks.add(task);
    }

    public void deleteTaskById(int id) {
        Predicate<? super Task> predicate = task -> task.getId() == id;
        tasks.removeIf(predicate);
        --taskCount;
    }

    public Task findTaskById(int id) {
        Predicate<? super Task> predicate = task -> task.getId() == id;
        Task task = tasks.stream().filter(predicate).findFirst().get();
        return task;
    }

    public void updateTodo(Task task) {
        deleteTaskById(task.getId());
        tasks.add(task);
    }
}
