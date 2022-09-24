package com.summarizer.complaints.domain.complaints;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity @Table(name="summarizedFile")
public class SummarizedEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String complaintId;

    @Column
    private String originalTextId;

    @Column
    private String originalVoiceId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String content;

    @Column
    private String keywords;

    @Builder
    public SummarizedEntity(String complaintId, String originalTextId, String originalVoiceId, String username, String title, String content, String keywords) {
        this.complaintId = complaintId;
        this.originalTextId = originalTextId;
        this.originalVoiceId = originalVoiceId;
        this.username = username;
        this.title = title;
        this.content = content;
        this.keywords = keywords;
    }
}
