package com.summarizer.complaints.web.complaints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.summarizer.complaints.domain.complaints.VoiceEntity;
import com.summarizer.complaints.service.complaints.ComplaintService;
import com.summarizer.complaints.service.complaints.OriginalService;
import com.summarizer.complaints.service.complaints.SummarizedService;
import com.summarizer.complaints.service.complaints.VoiceService;
import com.summarizer.complaints.web.complaints.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @GetMapping(value = "/summarized/{id}") // 요약본 조회
    public SummarizedGetResponseDTO getSummarized(@PathVariable Long id) {
        return summarizedService.GetSummarizedByID(id);
    }

    @GetMapping(value = "/summarized-list/{name}") // 요약본 조회
    public List<SummarizedGetResponseDTO> getSummarized(@PathVariable String name) {
        return summarizedService.GetSummarizedListByComplaintName(name);
    }

    @PostMapping(value= "/original") // 원본 파일 업로드
    public OriginalPostResponseDTO postOriginal(@RequestBody OriginalPostRequestDTO originalPostRequestDTO) {
        return originalService.postOriginal(originalPostRequestDTO);
    }

    @GetMapping(value = "/original/{id}") // 원본 파일 다운로드
    public OriginalGetResponseDTO getOriginal(@PathVariable Long id) {
        return originalService.getOriginal(id);
    }

    @PostMapping(value = "/complaint") // 민원인 데이터 삽입
    public ComplaintPostResponseDTO postComplaint(@RequestBody ComplaintPostRequestDTO complaintPostRequestDTO) {
        return complaintService.postComplaintService(complaintPostRequestDTO);
    }

    @GetMapping(value = "/complaint/{id}") // 민원인 데이터 조회
    public ComplaintGetResponseDTO getComplaintByID(@PathVariable Long id) {
        return complaintService.getComplaintByID(id);
    }

    @GetMapping(value = "/complaint-list/{name}") // 민원인 이름으로 민원인 리스트 조회
    public List<ComplaintGetResponseDTO> getComplaintsByName(@PathVariable String name) {
        return complaintService.getComplaintsByName(name);
    }
}