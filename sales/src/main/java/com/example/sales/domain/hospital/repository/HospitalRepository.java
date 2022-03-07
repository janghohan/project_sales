package com.example.sales.domain.hospital.repository;

import com.example.sales.domain.hospital.dto.HospitalDto;
import com.example.sales.domain.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

//    List<Hospital> findAllById(String uuid);
    List<Hospital> findAllByUuid(String uuid);
    List<Hospital> findAllByUuidOrderByConCodeAsc(String uuid);
    Optional<Hospital> findByUuidAndIx(String uuid, Integer ix);
}
