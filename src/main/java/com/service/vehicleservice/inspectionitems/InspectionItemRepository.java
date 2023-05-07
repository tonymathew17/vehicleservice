package com.service.vehicleservice.inspectionitems;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InspectionItemRepository extends JpaRepository<InspectionItem, UUID> {
}
