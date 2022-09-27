package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.SummarizedEntity;
import com.summarizer.complaints.domain.complaints.SummarizedRepository;
import com.summarizer.complaints.web.complaints.dto.SummarizedPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class SummarizedService {

    private final SummarizedRepository summarizedRepository;

    @Transactional
    public SummarizedEntity postSummarized(SummarizedPostRequestDTO summarizedPostRequestDTO) throws IOException {
        SummarizedEntity summarizedEntity  = summarizedRepository.save(SummarizedEntity.builder()
                .complaintId(summarizedPostRequestDTO.getComplaintId())
                .originalTextId(summarizedPostRequestDTO.getOriginalTextId())
                .originalVoiceId(summarizedPostRequestDTO.getOriginalVoiceId())
                .username(summarizedPostRequestDTO.getUsername())
                .title(summarizedPostRequestDTO.getTitle())
                .content(summarizedPostRequestDTO.getContent())
                .keywords(summarizedPostRequestDTO.getKeywords().toString())
                .build());
        return summarizedEntity;
    }

    public SummarizedEntity GetSummarized(Long id){
        return  summarizedRepository.findSummarizedEntityById(id);
    }
}
