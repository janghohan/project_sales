package com.example.sales.domain.hospital.service;

import com.example.sales.common.util.DateFormat;
import com.example.sales.domain.hospital.dto.*;
import com.example.sales.domain.hospital.entity.Hospital;
import com.example.sales.domain.hospital.entity.Memo;
import com.example.sales.domain.hospital.repository.HospitalRepository;
import com.example.sales.domain.hospital.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final MemoRepository memoRepository;

    public List<Hospital> getHospitalList(String uuid){
        List<Hospital> hospitalList = hospitalRepository.findAllByUuid(uuid);
        return hospitalList;
    }

    public Optional<Hospital> getHospital(int ix){
        Optional<Hospital> hospital = hospitalRepository.findById(ix);
        return hospital;
    }

    public List<Memo> getMemoList(String uuid, Integer hospitalId){
        List<Memo> memoList = memoRepository.findByUuidAndHospitalId(uuid,hospitalId);
        return memoList;
    }
    public Optional<Memo> getMemo(int ix){
        Optional<Memo> memo = memoRepository.findById(ix);
        return memo;
    }

    public Hospital saveHospital(HospitalSaveEvent hospitalSaveEvent){
        int ix = hospitalRepository.save(hospitalSaveEvent.toEntity()).getIx();
        Hospital hospital = new Hospital();
        hospital.setIx(ix);
        return hospital;
    }

    public Memo saveMemo(MemoSaveEvent memoSaveEvent) {
        int ix = memoRepository.save(memoSaveEvent.toEntity()).getIx();
        Memo memo = new Memo();
        memo.setIx(ix);
        return memo;
    }

    public void updateHospital(HospitalSaveEvent hospitalSaveEvent, int ix) {
        Optional<Hospital> hospital = hospitalRepository.findByUuidAndIx(hospitalSaveEvent.getUuid(), ix);
        hospital.ifPresent(h -> {
            h.setUptDt(DateFormat.getCurrentTime());
            h.setManager(hospitalSaveEvent.getManager());
            h.setContact1(hospitalSaveEvent.getContact1());
            h.setContact2(hospitalSaveEvent.getContact2());
            h.setName(hospitalSaveEvent.getName());
            h.setMemo(hospitalSaveEvent.getMemo());
            h.setAddressCode(hospitalSaveEvent.getAddressCode());
            h.setAddressLot(hospitalSaveEvent.getAddressLot());
            h.setAddressStreet(hospitalSaveEvent.getAddressStreet());
            h.setLatitude(hospitalSaveEvent.getLatitude());
            h.setLongitude(hospitalSaveEvent.getLongitude());
            hospitalRepository.save(h);
        });
        return;
    }

    public void updateMemo(MemoSaveEvent memoSaveEvent, int ix) {
        Optional<Memo> memo = memoRepository.findByUuidAndHospitalIdAndIx(memoSaveEvent.getUuid(), memoSaveEvent.getHospitalId(), ix);
        memo.ifPresent(m -> {
            m.setUptDt(DateFormat.getCurrentTime());
            m.setMemo(memoSaveEvent.getMemo());
            memoRepository.save(m);
        });
        return;
    }

    public void deleteHospital(HospitalDeleteEvent hospitalDeleteEvent, int ix) {
        Optional<Hospital> hospital = hospitalRepository.findByUuidAndIx(hospitalDeleteEvent.getUuid(), ix);
        hospital.ifPresent(h -> {
            hospitalRepository.delete(h);
        });
    }

    public void deleteMemo(MemoDeleteEvent memoDeleteEvent, int ix) {
        Optional<Memo> memo = memoRepository.findByUuidAndHospitalIdAndIx(memoDeleteEvent.getUuid(), memoDeleteEvent.getHospitalId(), ix);
        memo.ifPresent(m -> {
            memoRepository.delete(m);
        });
        return;
    }

}
