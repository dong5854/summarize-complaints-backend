package com.summarizer.complaints.domain.complaints;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor @Getter
@Entity @Table(name="OriginalFile")
public class OriginalEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String complaintId;

    @Column
    private String originalVoiceId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Builder
    public OriginalEntity(String complaintId, String originalVoiceId, String title, String content){
        this.complaintId = complaintId;
        this.originalVoiceId = originalVoiceId;
        this.title = title;
        this.content = content;
    }
}
