package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.OriginalEntity;
import com.summarizer.complaints.domain.complaints.OriginalRepository;
import com.summarizer.complaints.web.complaints.dto.OriginalGetResponseDTO;
import com.summarizer.complaints.web.complaints.dto.OriginalPostRequestDTO;
import com.summarizer.complaints.web.complaints.dto.OriginalPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OriginalService {

    private final OriginalRepository originalRepository;

    @Transactional
    public OriginalPostResponseDTO postOriginal(OriginalPostRequestDTO originalPostRequestDTO){
        OriginalEntity originalEntity = originalRepository.save(OriginalEntity.builder().
                complaintId(originalPostRequestDTO.getComplaintId())
                .originalVoiceId(originalPostRequestDTO.getOriginalVoiceId())
                .title(originalPostRequestDTO.getTitle())
                .title(originalPostRequestDTO.getTitle())
                .build());
        return new OriginalPostResponseDTO(originalEntity.getId(), originalEntity.getComplaintId(), originalEntity.getOriginalVoiceId(), originalEntity.getTitle());
    }

    public OriginalGetResponseDTO getOriginal(Long id){
        OriginalEntity originalEntity =  originalRepository.findOriginalEntityById(id);
        return new OriginalGetResponseDTO(originalEntity.getId(), originalEntity.getComplaintId(), originalEntity.getOriginalVoiceId(), originalEntity.getTitle(), originalEntity.getContent());
    }
}
