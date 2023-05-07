package com.service.vehicleservice.inspectionitems;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inspection_items")
public class InspectionItem {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String item;

    private Values value;

    public InspectionItem(String item, Values value) {
        this.item = item;
        this.value = value;
    }

    public static InspectionItem toEntity(InspectionItemDto inspectionItem) {
        return new InspectionItem(inspectionItem.getItem(), inspectionItem.getValue());
    }
}
