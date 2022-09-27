package com.summarizer.complaints.domain.complaints;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor @Getter
@Entity @Table(name="Complaint")
public class ComplaintEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    boolean blackListed;

    @Builder
    public ComplaintEntity(String name, boolean blackListed){
        this.name = name;
        this.blackListed = blackListed;
    }
}
