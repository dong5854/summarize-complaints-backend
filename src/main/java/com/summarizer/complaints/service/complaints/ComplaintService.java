package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.ComplaintEntity;
import com.summarizer.complaints.domain.complaints.ComplaintRepository;
import com.summarizer.complaints.web.complaints.dto.ComplaintPostRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Transactional
    public ComplaintEntity postComplaintService(ComplaintPostRequestDTO complaintPostRequestDTO){
            ComplaintEntity complaintEntity = ComplaintEntity.builder()
                    .name(complaintPostRequestDTO.getName())
                    .blackListed(complaintPostRequestDTO.isBlackListed())
                    .build();
            return complaintEntity;
    }

    public ComplaintEntity getComplaintService(Long id){
            return complaintRepository.findComplaintEntityById(id);
    }
}
