package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.ComplaintEntity;
import com.summarizer.complaints.domain.complaints.ComplaintRepository;
import com.summarizer.complaints.web.complaints.dto.ComplaintGetResponseDTO;
import com.summarizer.complaints.web.complaints.dto.ComplaintPostRequestDTO;
import com.summarizer.complaints.web.complaints.dto.ComplaintPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Transactional
    public ComplaintPostResponseDTO postComplaintService(ComplaintPostRequestDTO complaintPostRequestDTO){
            ComplaintEntity complaintEntity = ComplaintEntity.builder()
                    .name(complaintPostRequestDTO.getName())
                    .blackListed(complaintPostRequestDTO.isBlackListed())
                    .build();
        return new ComplaintPostResponseDTO(complaintEntity.getId(), complaintEntity.getName(), complaintEntity.isBlackListed());
    }

    public ComplaintGetResponseDTO getComplaintService(Long id){
            ComplaintEntity complaintEntity =  complaintRepository.findComplaintEntityById(id);
        return new ComplaintGetResponseDTO(complaintEntity.getId(), complaintEntity.getName(), complaintEntity.isBlackListed());
    }
}
