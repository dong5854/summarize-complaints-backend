package com.summarizer.complaints.web.complaints.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class OriginalGetResponseDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("complaint_id")
    private String complaintId;
    @JsonProperty("original_voice_id")
    private String originalVoiceId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
}
