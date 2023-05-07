package com.service.vehicleservice.tasks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TasksService {
    private final TaskRepository taskRepository;

    public Task create(TaskDto task) {
        Task taskEntity = Task.toEntity(task);
        return this.taskRepository.save(taskEntity);
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<Task>();
        this.taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    public Task findOne(UUID id) {
        return this.taskRepository.findById(id).orElse(null);
    }

    public Task replace(UUID id, TaskDto task) {
        Task taskInDb = this.findOne(id);
        if (taskInDb != null) {
            taskInDb.setTask(task.getTask());
            taskInDb.setMinMileage(task.getMinMileage());
            taskInDb.setMaxMileage(task.getMaxMileage());
            taskInDb.setPrice(task.getPrice());
            return this.taskRepository.save(taskInDb);
        } else {
            Task taskEntity = Task.toEntity(task);
            return this.taskRepository.save(taskEntity);
        }
    }
}
