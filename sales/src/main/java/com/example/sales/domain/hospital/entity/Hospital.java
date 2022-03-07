package com.example.sales.domain.hospital.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hospital")
@AllArgsConstructor
@DynamicUpdate
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ix", unique = true, nullable = false)
    private Integer ix;
    private int conCode;
    private String uuid;
    private String latitude;
    private String longitude;
    private String addressStreet;
    private String addressLot;
    private String addressCode;
    private String name;
    private String manager;
    private String contact1;
    private String contact2;
    private String memo;
    private String regDt;
    private String uptDt;
}
