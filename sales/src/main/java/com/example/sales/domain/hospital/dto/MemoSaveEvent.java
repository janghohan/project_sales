package com.example.sales.domain.hospital.dto;

import com.example.sales.common.util.DateFormat;
import com.example.sales.domain.hospital.entity.Memo;
import lombok.Getter;

@Getter
public class MemoSaveEvent {
    private String uuid;
    private Integer hospitalId;
    private String memo;

    public Memo toEntity() {
        return Memo
                .builder()
                .uuid(this.uuid)
                .hospitalId(this.hospitalId)
                .memo(this.memo)
                .uptDt(DateFormat.getCurrentTime())
                .regDt(DateFormat.getCurrentTime())
                .build();
    }
}
