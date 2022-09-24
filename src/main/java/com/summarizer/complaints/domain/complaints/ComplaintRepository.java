package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Long> {
    ComplaintEntity findComplaintEntityById(Long id);
    ComplaintEntity findComplaintEntitiesByName(String name);
}
