package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoiceRepository extends JpaRepository<VoiceEntity, Long> {
    VoiceEntity findVoiceEntityById(Long id);
    List<VoiceEntity> findVoiceEntitiesByComplaintId(Long id);
}