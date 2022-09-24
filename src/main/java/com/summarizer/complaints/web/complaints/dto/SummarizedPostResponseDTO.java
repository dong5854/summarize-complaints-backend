package com.summarizer.complaints.web.complaints.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor
@ToString
public class SummarizedPostResponseDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("username")
    private String username;
    @JsonProperty("complaint_id")
    private String complaintId;
    @JsonProperty("original_text_id")
    private String originalTextId;
    @JsonProperty("original_voice_id")
    private String originalVoiceId;
    @JsonProperty("keywords")
    private String keywords;
}