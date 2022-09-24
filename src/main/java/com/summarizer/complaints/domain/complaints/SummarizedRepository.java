package com.summarizer.complaints.domain.complaints;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummarizedRepository extends JpaRepository<SummarizedEntity, String> {
    SummarizedEntity findByUsername(String username);
}
