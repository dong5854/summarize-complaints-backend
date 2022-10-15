package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {
    ComplaintEntity findComplaintEntityById(Long id);
    List<ComplaintEntity> findComplaintEntitiesByName(String name);
}
