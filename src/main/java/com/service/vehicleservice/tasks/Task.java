package com.service.vehicleservice.tasks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String task;

    private int minMileage;

    private int maxMileage;

    private int price;

    public Task(String task, int minMileage, int maxMileage, int price) {
        this.task = task;
        this.minMileage = minMileage;
        this.maxMileage = maxMileage;
        this.price = price;
    }

    public static Task toEntity(TaskDto task) {
        return new Task(task.getTask(), task.getMinMileage(), task.getMaxMileage(), task.getPrice());
    }
}
