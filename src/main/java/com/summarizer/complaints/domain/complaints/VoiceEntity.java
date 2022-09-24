package com.summarizer.complaints.domain.complaints;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;


@NoArgsConstructor @Getter
@Entity @Table(name="VoiceFile")
public class VoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String complaintId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "LONGBLOB")
    private byte[] content;

    @Builder
    public VoiceEntity(String complaintId, String title, byte[] content){
        this.complaintId = complaintId;
        this.title = title;
        this.content = content;
    }
}