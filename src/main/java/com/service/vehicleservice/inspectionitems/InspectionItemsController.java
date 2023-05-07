package com.service.vehicleservice.inspectionitems;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/inspection-items")
public class InspectionItemsController {

    private final InspectionItemsService inspectionItemsService;
    @PostMapping
    public ResponseEntity<InspectionItem> create(@Valid @RequestBody InspectionItemDto inspectionItem) {
        InspectionItem newInspectionItem = this.inspectionItemsService.create(inspectionItem);
        return new ResponseEntity<>(newInspectionItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<InspectionItem> findOne(@PathVariable("id") UUID id) {
        InspectionItem inspectionItem = this.inspectionItemsService.findOne(id);
        return new ResponseEntity<>(inspectionItem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InspectionItem>> findAll() {
        List<InspectionItem> inspectionItems = this.inspectionItemsService.findAll();
        return new ResponseEntity<>(inspectionItems, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<InspectionItem> replace(@PathVariable("id") UUID id, @Valid @RequestBody InspectionItemDto newInspectionItem) {
        InspectionItem inspectionItem = this.inspectionItemsService.replace(id, newInspectionItem);
        return new ResponseEntity<>(inspectionItem, HttpStatus.OK);
    }
}
