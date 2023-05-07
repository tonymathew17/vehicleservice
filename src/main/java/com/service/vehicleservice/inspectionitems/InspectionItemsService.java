package com.service.vehicleservice.inspectionitems;

import com.service.vehicleservice.tasks.Task;
import com.service.vehicleservice.tasks.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InspectionItemsService {

    private final InspectionItemRepository inspectionItemRepository;

    public InspectionItem create(InspectionItemDto inspectionItem) {
        InspectionItem inspectionItemEntity = InspectionItem.toEntity(inspectionItem);
        return this.inspectionItemRepository.save(inspectionItemEntity);
    }

    public InspectionItem findOne(UUID id) {
        return this.inspectionItemRepository.findById(id).orElse(null);
    }

    public List<InspectionItem> findAll() {
        List<InspectionItem> inspectionItems = new ArrayList<>();
        this.inspectionItemRepository.findAll().forEach(
                inspectionItem ->
                inspectionItems.add(inspectionItem));
        return inspectionItems;
    }

    public InspectionItem replace(UUID id, InspectionItemDto inspectionItem) {
        InspectionItem inspectionItemInDb = this.findOne(id);
        if (inspectionItemInDb != null) {
            inspectionItemInDb.setItem(inspectionItem.getItem());
            inspectionItemInDb.setValue(inspectionItem.getValue());
            return this.inspectionItemRepository.save(inspectionItemInDb);
        } else {
            InspectionItem newInspectionItem = InspectionItem.toEntity(inspectionItem);
            return this.inspectionItemRepository.save(newInspectionItem);
        }
    }
}
