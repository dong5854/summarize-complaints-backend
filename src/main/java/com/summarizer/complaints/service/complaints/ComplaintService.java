package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.ComplaintEntity;
import com.summarizer.complaints.domain.complaints.ComplaintRepository;
import com.summarizer.complaints.web.complaints.dto.ComplaintGetResponseDTO;
import com.summarizer.complaints.web.complaints.dto.ComplaintPostRequestDTO;
import com.summarizer.complaints.web.complaints.dto.ComplaintPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        ComplaintEntity savedComplaintEntity = complaintRepository.save(complaintEntity);
        return new ComplaintPostResponseDTO(savedComplaintEntity.getId(), savedComplaintEntity.getName(), savedComplaintEntity.isBlackListed());
    }

    public ComplaintGetResponseDTO getComplaintByID(Long id){
            ComplaintEntity complaintEntity =  complaintRepository.findComplaintEntityById(id);
        return new ComplaintGetResponseDTO(complaintEntity.getId(), complaintEntity.getName(), complaintEntity.isBlackListed());
    }

    @Transactional(readOnly = true)
    public List<ComplaintGetResponseDTO> getComplaintsByName(String name){
        return complaintRepository.findComplaintEntitiesByName(name).stream()
                .map(c -> new ComplaintGetResponseDTO(c.getId(), c.getName(), c.isBlackListed()))
                .collect(Collectors.toList());
    }
}
