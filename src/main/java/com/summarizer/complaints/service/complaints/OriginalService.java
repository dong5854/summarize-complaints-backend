package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.OriginalEntity;
import com.summarizer.complaints.domain.complaints.OriginalRepository;
import com.summarizer.complaints.web.complaints.dto.OriginalPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OriginalService {

    private final OriginalRepository originalRepository;

    @Transactional
    public OriginalEntity postOriginal(OriginalPostRequestDTO originalPostRequestDTO){
        OriginalEntity originalEntity = originalRepository.save(OriginalEntity.builder().
                complaintId(originalPostRequestDTO.getComplaintId())
                .originalVoiceId(originalPostRequestDTO.getOriginalVoiceId())
                .title(originalPostRequestDTO.getTitle())
                .title(originalPostRequestDTO.getTitle())
                .build());
        return originalEntity;
    }

    public OriginalEntity getOriginal(Long id){
        return originalRepository.findOriginalEntityById(id);
    }
}
