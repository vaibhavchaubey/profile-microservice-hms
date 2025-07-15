package com.hms.profile.service;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.profile.dto.DoctorDTO;
import com.hms.profile.exception.HmsException;
import com.hms.profile.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void addDoctor(DoctorDTO doctorDTO) throws HmsException {
        if (doctorRepository.existsById(doctorDTO.getId())) {
            throw new HmsException("DOCTOR_ALREADY_EXISTS");
        }

        doctorRepository.save(doctorDTO.toEntity());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HmsException {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new HmsException("DOCTOR_NOT_FOUND")).toDTO();
    }

}
