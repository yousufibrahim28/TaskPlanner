package com.yousufibrahim28.TaskPlanner.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findByUsername(String username);
    
}
