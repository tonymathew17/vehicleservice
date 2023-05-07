package com.service.vehicleservice.tasks;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TasksController {

    private final TasksService tasksService;

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody TaskDto task) {
        Task newTask = this.tasksService.create(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> findOne(@PathVariable("id") UUID id) {
        Task task = this.tasksService.findOne(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = this.tasksService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> replace(@PathVariable("id") UUID id, @Valid @RequestBody TaskDto newTask) {
        Task task = this.tasksService.replace(id, newTask);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
