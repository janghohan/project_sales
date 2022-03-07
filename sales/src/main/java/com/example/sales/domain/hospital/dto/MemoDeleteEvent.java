package com.example.sales.domain.hospital.dto;

import lombok.Getter;

@Getter
public class MemoDeleteEvent {
    private String uuid;
    private Integer hospitalId;
}
