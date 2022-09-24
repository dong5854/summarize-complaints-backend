package com.summarizer.complaints.domain.complaints;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity @Table(name="Complaint")
public class ComplaintEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    boolean black_listed;
}
