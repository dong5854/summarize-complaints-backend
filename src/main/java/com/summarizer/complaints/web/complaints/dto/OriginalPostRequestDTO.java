package com.summarizer.complaints.web.complaints.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OriginalPostRequestDTO {
    private String complaintId;
    private String originalVoiceId;
    private String title;
    private String content;
}
