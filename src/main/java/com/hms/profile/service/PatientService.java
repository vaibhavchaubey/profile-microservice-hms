package com.hms.profile.service;

import com.hms.profile.dto.PatientDTO;
import com.hms.profile.exception.HmsException;

public interface PatientService {
    public void addPatient(PatientDTO patientDTO) throws HmsException;

    public PatientDTO getPatientById(Long id) throws HmsException;

}