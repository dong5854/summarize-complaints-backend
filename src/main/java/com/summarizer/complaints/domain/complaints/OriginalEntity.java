package com.summarizer.complaints.domain.complaints;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
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
}
