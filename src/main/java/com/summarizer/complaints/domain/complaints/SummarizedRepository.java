package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummarizedRepository extends JpaRepository<SummarizedEntity, Long> {
    SummarizedEntity findSummarizedEntityById(Long id);
    SummarizedEntity findSummarizedEntityByComplaintId(String complaintId);
    SummarizedEntity findSummarizedEntityByOriginalTextId(String originalTextId);
    SummarizedEntity findSummarizedEntityByOriginalVoiceId(String originalVoiceId);
    List<SummarizedEntity> findSummarizedEntitiesByUsername(String username);

}
