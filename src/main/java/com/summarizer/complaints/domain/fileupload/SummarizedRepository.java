package com.summarizer.complaints.domain.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummarizedRepository extends JpaRepository<SummarizedEntity, String> {
    SummarizedEntity findByUsername(String username);
}
