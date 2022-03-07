package com.example.sales.domain.hospital.dto;

import com.example.sales.domain.hospital.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoDto {
    private final Memo memo;
}
