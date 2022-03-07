package com.example.sales.domain.hospital.repository;

import com.example.sales.domain.hospital.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Integer> {
    List<Memo> findByUuidAndHospitalId(String uuid, Integer hospitalId);
    Optional<Memo> findByUuidAndHospitalIdAndIx(String uuid, Integer hospitalId, Integer ix);
}
