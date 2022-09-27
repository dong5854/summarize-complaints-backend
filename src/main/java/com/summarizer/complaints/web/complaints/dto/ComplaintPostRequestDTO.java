package com.summarizer.complaints.web.complaints.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ComplaintPostRequestDTO {
    private String name;
    private boolean blackListed;
}