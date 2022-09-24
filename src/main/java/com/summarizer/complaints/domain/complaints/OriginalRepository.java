package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OriginalRepository extends JpaRepository<OriginalEntity, Long> {
    OriginalEntity findOriginalEntityById(Long id);
    List<OriginalEntity> findOriginalEntitiesByComplaintId(String complaintId);
    OriginalEntity findOriginalEntityByOriginalVoiceId(String originalVoiceID);
}
