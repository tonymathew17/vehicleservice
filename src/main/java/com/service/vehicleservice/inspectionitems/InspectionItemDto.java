package com.service.vehicleservice.inspectionitems;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InspectionItemDto {
    @NotNull
    private String item;

    @NotNull
    private Values value;
}

@JsonFormat(shape = JsonFormat.Shape.STRING)
enum Values{
    X,O
}

