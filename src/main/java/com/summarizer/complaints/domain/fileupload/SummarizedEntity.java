package com.summarizer.complaints.domain.fileupload;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Getter @ToString
@Table(name="summarizedFiles")
public class SummarizedEntity {
    @Id
    private String filename;
    private String filepath;
    private String username;
}
