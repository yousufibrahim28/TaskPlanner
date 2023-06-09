package com.yousufibrahim28.TaskPlanner.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=10, message="Enter at least ten characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
