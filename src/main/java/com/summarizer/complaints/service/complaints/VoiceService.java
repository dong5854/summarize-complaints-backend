package com.summarizer.complaints.service.complaints;

import com.summarizer.complaints.domain.complaints.VoiceEntity;
import com.summarizer.complaints.domain.complaints.VoiceRepository;
import com.summarizer.complaints.web.complaints.dto.VoiceUploadRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class VoiceService {

    private final VoiceRepository voiceRepository;

    @Transactional
    public VoiceEntity postVideo(VoiceUploadRequestDTO voiceUploadRequestDTO) throws IOException {
        VoiceEntity voiceEntity = voiceRepository.save(VoiceEntity.builder()
                                .complaintId(voiceUploadRequestDTO.getComplaintId())
                                .title(voiceUploadRequestDTO.getTitle())
                                .content(voiceUploadRequestDTO.getFile().getBytes())
                                .build());
        return voiceEntity;
    }

    public VoiceEntity GetVideo(Long id){
        return  voiceRepository.findVoiceEntityById(id);
    }
}
