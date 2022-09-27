package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.SummarizedEntity;
import com.summarizer.complaints.domain.complaints.SummarizedRepository;
import com.summarizer.complaints.web.complaints.dto.SummarizedGetResponseDTO;
import com.summarizer.complaints.web.complaints.dto.SummarizedPostRequestDTO;
import com.summarizer.complaints.web.complaints.dto.SummarizedPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class SummarizedService {

    private final SummarizedRepository summarizedRepository;

    @Transactional
    public SummarizedPostResponseDTO postSummarized(SummarizedPostRequestDTO summarizedPostRequestDTO) throws IOException {
        SummarizedEntity summarizedEntity  = summarizedRepository.save(SummarizedEntity.builder()
                .complaintId(summarizedPostRequestDTO.getComplaintId())
                .originalTextId(summarizedPostRequestDTO.getOriginalTextId())
                .originalVoiceId(summarizedPostRequestDTO.getOriginalVoiceId())
                .username(summarizedPostRequestDTO.getUsername())
                .title(summarizedPostRequestDTO.getTitle())
                .content(summarizedPostRequestDTO.getContent())
                .keywords(summarizedPostRequestDTO.getKeywords().toString())
                .build());
        return new SummarizedPostResponseDTO(summarizedEntity.getId(), summarizedEntity.getTitle(), summarizedEntity.getUsername(), summarizedEntity.getComplaintId(), summarizedEntity.getOriginalTextId(), summarizedEntity.getOriginalVoiceId(), summarizedEntity.getKeywords());
    }

    public SummarizedGetResponseDTO GetSummarized(Long id){
        SummarizedEntity summarizedEntity = summarizedRepository.findSummarizedEntityById(id);
        return new SummarizedGetResponseDTO(summarizedEntity.getId(), summarizedEntity.getTitle(), summarizedEntity.getUsername(), summarizedEntity.getComplaintId(), summarizedEntity.getOriginalTextId(), summarizedEntity.getOriginalVoiceId(), summarizedEntity.getKeywords(), summarizedEntity.getContent());
    }
}
