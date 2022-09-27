package com.summarizer.complaints.web.complaints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.summarizer.complaints.domain.complaints.ComplaintEntity;
import com.summarizer.complaints.domain.complaints.OriginalEntity;
import com.summarizer.complaints.domain.complaints.SummarizedEntity;
import com.summarizer.complaints.domain.complaints.VoiceEntity;
import com.summarizer.complaints.service.complaints.ComplaintService;
import com.summarizer.complaints.service.complaints.OriginalService;
import com.summarizer.complaints.service.complaints.SummarizedService;
import com.summarizer.complaints.service.complaints.VoiceService;
import com.summarizer.complaints.web.complaints.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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
    private final SummarizedService summarizedService;
    private final OriginalService originalService;
    private final ComplaintService complaintService;
    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/voice") // 음성 파일 업로드
    public VoiceUploadResponseDTO voiceUpload(@ModelAttribute VoiceUploadRequestDTO voiceUploadRequestDTO) throws IOException {
        return voiceService.postVideo(voiceUploadRequestDTO);
    }

    @GetMapping(value = "/voice/{id}") // 음성 파일 다운로드
    public ResponseEntity<Resource> voiceDownload(@PathVariable Long id){
        VoiceEntity voiceEntity = voiceService.GetVideo(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + voiceEntity.getTitle() + ".mp3")
                .body(new ByteArrayResource(voiceEntity.getContent()));
    }

    @PostMapping(value = "/summarized") //요약본 업로드
    public SummarizedPostResponseDTO postSummarized(@RequestBody SummarizedPostRequestDTO summarizedPostRequestDTO) throws IOException {
        return summarizedService.postSummarized(summarizedPostRequestDTO);
    }

    @GetMapping(value = "/summarized/{id}") // 요약본 다운로드
    public SummarizedGetResponseDTO getSummarized(@PathVariable Long id) {
        return summarizedService.GetSummarized(id);
    }

    @PostMapping(value= "/original") // 원본 파일 업로드
    public OriginalPostResponseDTO postOriginal(@RequestBody OriginalPostRequestDTO originalPostRequestDTO) throws JsonProcessingException {
        return originalService.postOriginal(originalPostRequestDTO);
    }

    @GetMapping(value = "/original/{id}") // 원본 파일 다운로드
    public OriginalGetResponseDTO getOriginal(@PathVariable Long id) throws JsonProcessingException {
        return originalService.getOriginal(id);
    }

    @PostMapping(value = "/complaint") // 민원인 데이터 삽입
    public String postComplaint(@RequestBody ComplaintPostRequestDTO complaintPostRequestDTO) throws JsonProcessingException {
        ComplaintEntity complaintEntity = complaintService.postComplaintService(complaintPostRequestDTO);
        ComplaintPostResponseDTO complaintPostResponseDTO = new ComplaintPostResponseDTO(complaintEntity.getId(), complaintEntity.getName(), complaintEntity.isBlackListed());
        return mapper.writeValueAsString(complaintPostResponseDTO);
    }

    @GetMapping(value = "/complaint/{id}") // 민원인 데이터 조회
    public String getComplaint(@PathVariable Long id) throws JsonProcessingException {
        ComplaintEntity complaintEntity = complaintService.getComplaintService(id);
        ComplaintGetResponseDTO complaintGetResponseDTO = new ComplaintGetResponseDTO(complaintEntity.getId(), complaintEntity.getName(), complaintEntity.isBlackListed());
        return mapper.writeValueAsString(complaintGetResponseDTO);
    }
}