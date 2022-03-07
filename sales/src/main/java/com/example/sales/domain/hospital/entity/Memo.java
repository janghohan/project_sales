package com.example.sales.domain.hospital.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "memo")
@AllArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ix", unique = true, nullable = false)
    private Integer ix;
    private String uuid;
    private Integer hospitalId;
    private String memo;
    private String regDt;
    private String uptDt;
}
