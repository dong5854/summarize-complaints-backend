package com.summarizer.complaints.web.complaints.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.util.List;

@Getter @Setter
public class SummarizedPostRequestDTO {
    private String complaintId;
    private String originalTextId;
    private String originalVoiceId;
    private String username;
    private String title;
    private String content;
    private List<String> keywords;
}
