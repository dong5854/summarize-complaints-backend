package com.summarizer.complaints.web.complaints.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class VoiceUploadRequestDTO {
    private String complaintId;
    private String title;
    private MultipartFile file;
}
