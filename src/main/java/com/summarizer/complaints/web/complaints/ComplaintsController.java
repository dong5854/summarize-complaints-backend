package com.summarizer.complaints.web.complaints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.summarizer.complaints.domain.complaints.VoiceEntity;
import com.summarizer.complaints.service.fileupload.VoiceService;
import com.summarizer.complaints.web.complaints.dto.VoiceUploadRequestDTO;
import com.summarizer.complaints.web.complaints.dto.VoiceUploadResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ComplaintsController {
    private final VoiceService voiceService;
    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/voice") // 음성 파일 업로드
    public String voiceUpload(@ModelAttribute VoiceUploadRequestDTO voiceUploadRequestDTO) throws IOException {
        VoiceEntity voiceEntity = voiceService.postVideo(voiceUploadRequestDTO);

        VoiceUploadResponseDTO voiceUploadResponseDTO = new VoiceUploadResponseDTO(voiceEntity.getId(), voiceEntity.getTitle(), voiceEntity.getComplaintId());
        return mapper.writeValueAsString(voiceUploadResponseDTO);
    }

    @GetMapping(value = "/voice/{id}") // 음성 파일 다운로드
    public ResponseEntity<Resource> voiceDownload(@PathVariable Long id){
        VoiceEntity voiceEntity = voiceService.GetVideo(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + voiceEntity.getTitle() + ".mp3")
                .body(new ByteArrayResource(voiceEntity.getContent()));
    }
}