package com.example.sales.domain.hospital.dto;

import com.example.sales.domain.hospital.entity.Hospital;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class HospitalDto {
    private final Hospital hospital;
}
