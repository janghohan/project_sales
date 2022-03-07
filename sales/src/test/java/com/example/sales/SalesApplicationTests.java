package com.example.sales;

import com.example.sales.domain.hospital.entity.Hospital;
import com.example.sales.domain.hospital.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SalesApplicationTests {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void contextLoads() {
        List<Hospital> aa  = hospitalRepository.findAllByUuid("D4F1DFD222CZZ");
        Optional<Hospital> hospital = hospitalRepository.findById(1);

        System.out.println(aa.get(0).getName());

    }

}
