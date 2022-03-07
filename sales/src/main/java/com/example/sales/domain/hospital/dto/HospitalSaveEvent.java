package com.example.sales.domain.hospital.dto;

import com.example.sales.common.util.DateFormat;
import com.example.sales.domain.hospital.entity.Hospital;
import lombok.Getter;

@Getter
public class HospitalSaveEvent {
    private int ix;
    private String name;
    private String uuid;
    private int conCode;
    private String memo;
    private String manager;
    private String contact1;
    private String contact2;
    private String addressLot;
    private String addressStreet;
    private String addressCode;
    private String longitude;
    private String latitude;

    public Hospital toEntity() {
        return Hospital
                .builder()
                .uuid(this.uuid)
                .name(this.name)
                .conCode(this.conCode)
                .manager(this.manager)
                .memo(this.memo)
                .contact1(this.contact1)
                .contact2(this.contact2)
                .uptDt(DateFormat.getCurrentTime())
                .regDt(DateFormat.getCurrentTime())
                .build();
    }
}
