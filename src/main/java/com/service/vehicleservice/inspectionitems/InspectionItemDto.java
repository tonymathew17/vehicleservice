package com.service.vehicleservice.inspectionitems;
import jakarta.validation.constraints.NotNull;


public class InspectionItemDto {
    @NotNull
    private String item;

    @NotNull
    private String value;
}
