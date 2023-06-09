package com.yousufibrahim28.TaskPlanner.Task;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@AllArgsConstructor
@SessionAttributes("name")
public class TaskController {
    private TaskService taskService;

    @RequestMapping("list-tasks")
    public String listAllTasks(ModelMap model) {
        String username = getLogggedinUsername();
        List<Task> tasks = taskService.findByUsername(username);
        model.addAttribute("tasks", tasks);
        return "listTasks";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.GET)
    public String showNewTaskPage(ModelMap model) {
        String username = getLogggedinUsername();
        Task task = new Task(0,username,"",LocalDate.now().plusYears(1), false);
        model.put("task",task);
        return "task";
    }

    @RequestMapping(value = "add-task", method = RequestMethod.POST)
    public String addNewTaskPage(ModelMap model, @Valid Task task, BindingResult result) {
        if(result.hasErrors()) {
            return "task";
        }
        String username = getLogggedinUsername();
        taskService.addTask(username,task.getDescription(), task.getTargetDate(),false);
        return "redirect:list-tasks";
    }

    @RequestMapping("delete-task")
    public String deleteTask(@RequestParam int id) {
        taskService.deleteTaskById(id);
        return "redirect:list-tasks";
    }

    @RequestMapping(value = "update-task", method = RequestMethod.GET)
    public String showUpdateTaskPage(@RequestParam int id, ModelMap model) {
        Task task = taskService.findTaskById(id);
        model.put("task", task);
        return "task";
    }

    @RequestMapping(value = "update-task", method = RequestMethod.POST)
    public String showUpdatedListOfTasksPage(ModelMap model, @Valid Task task, BindingResult result) {
        if(result.hasErrors()) {
            return "task";
        }
        String username = (String) model.get("name");
        task.setUsername(username);
        taskService.updateTodo(task);
        return "redirect:list-tasks";
    }

        private String getLogggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
