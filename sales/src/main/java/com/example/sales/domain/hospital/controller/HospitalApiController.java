package com.example.sales.domain.hospital.controller;

import com.example.sales.domain.hospital.dto.*;
import com.example.sales.domain.hospital.entity.Hospital;
import com.example.sales.domain.hospital.entity.Memo;
import com.example.sales.domain.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/hospital")
@RequiredArgsConstructor
public class HospitalApiController {

    private final HospitalService hospitalService;

    @GetMapping("/list")
    public List<Hospital> getHospitalList(@RequestParam String uuid) {
        List<Hospital> hospitalList = hospitalService.getHospitalList(uuid);

        return hospitalList;
    }

    @GetMapping("/{ix}")
    public Optional<Hospital> getHospital(@PathVariable int ix) {
        Optional<Hospital> hospital = hospitalService.getHospital(ix);

        return hospital;
    }

    @GetMapping("/memo/list")
    public List<Memo> getMemoList(@RequestParam String uuid, @RequestParam Integer hospitalId) {
        List<Memo> memoList = hospitalService.getMemoList(uuid, hospitalId);

        return memoList;
    }

    @GetMapping("/memo/{ix}")
    public Optional<Memo> getMemo(@PathVariable int ix) {
        Optional<Memo> memo = hospitalService.getMemo(ix);

        return memo;
    }

    @PutMapping ("")
    public ResponseEntity<Hospital> saveHospital(@RequestBody HospitalSaveEvent hospitalSaveEvent) {
        Hospital hospital = hospitalService.saveHospital(hospitalSaveEvent);
        return new ResponseEntity(hospital, HttpStatus.OK);
    }

    @PutMapping ("/memo")
    public ResponseEntity<Memo> saveMemo(@RequestBody MemoSaveEvent memoSaveEvent) {
        Memo memo = hospitalService.saveMemo(memoSaveEvent);
        return new ResponseEntity(memo, HttpStatus.OK);
    }

    @PostMapping ("/{ix}")
    public void updateHospital(@RequestBody HospitalSaveEvent hospitalSaveEvent, @PathVariable int ix) {
        hospitalService.updateHospital(hospitalSaveEvent, ix);
        return ;
    }

    @PostMapping ("/memo/{ix}")
    public void updateMemo(@RequestBody MemoSaveEvent memoSaveEvent, @PathVariable int ix) {
        hospitalService.updateMemo(memoSaveEvent, ix);
        return ;
    }

    @DeleteMapping("/{ix}")
    public void deleteHospital(@RequestBody HospitalDeleteEvent hospitalDeleteEvent, @PathVariable int ix) {
        hospitalService.deleteHospital(hospitalDeleteEvent, ix);
        return ;
    }

    @DeleteMapping("/memo/{ix}")
    public void deleteMemo(@RequestBody MemoDeleteEvent memoDeleteEvent, @PathVariable int ix) {
        hospitalService.deleteMemo(memoDeleteEvent, ix);
        return ;
    }

}
