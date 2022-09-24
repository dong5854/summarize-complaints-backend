package com.summarizer.complaints.web.complaints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.summarizer.complaints.domain.complaints.SummarizedEntity;
import com.summarizer.complaints.domain.complaints.VoiceEntity;
import com.summarizer.complaints.service.fileupload.SummarizedService;
import com.summarizer.complaints.service.fileupload.VoiceService;
import com.summarizer.complaints.web.complaints.dto.*;
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
    private final SummarizedService summarizedService;
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

    @PostMapping(value = "/summarized") //요약본 업로드
    public String postSummarized(@RequestBody SummarizedPostRequestDTO summarizedPostRequestDTO) throws IOException {
        SummarizedEntity summarizedEntity = summarizedService.postSummarized(summarizedPostRequestDTO);

        SummarizedPostResponseDTO summarizedPostResponseDTO = new SummarizedPostResponseDTO(summarizedEntity.getId(), summarizedEntity.getTitle(), summarizedEntity.getUsername(), summarizedEntity.getComplaintId(), summarizedEntity.getOriginalTextId(), summarizedEntity.getOriginalVoiceId(), summarizedEntity.getKeywords());
        return mapper.writeValueAsString(summarizedPostResponseDTO);
    }

    @GetMapping(value = "/summarized/{id}") // 요약본 다운로드
    public String GetSummarized(@PathVariable Long id) throws JsonProcessingException {
        SummarizedEntity summarizedEntity = summarizedService.GetSummarized(id);
        SummarizedGetResponseDTO summarizedGetResponseDTO = new SummarizedGetResponseDTO(summarizedEntity.getId(), summarizedEntity.getTitle(), summarizedEntity.getUsername(), summarizedEntity.getComplaintId(), summarizedEntity.getOriginalTextId(), summarizedEntity.getOriginalVoiceId(), summarizedEntity.getKeywords(), summarizedEntity.getContent());
        return mapper.writeValueAsString(summarizedGetResponseDTO);
    }
}