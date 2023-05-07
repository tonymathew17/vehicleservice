package com.service.vehicleservice.tasks;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    @NotNull
    private String task;
    @NotNull
    private int minMileage;
    @NotNull
    private int maxMileage;
    @NotNull
    private int price;
}
