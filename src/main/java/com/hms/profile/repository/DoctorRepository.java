package com.hms.profile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hms.profile.dto.DoctorDropdown;
import com.hms.profile.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);

    Optional<Doctor> findByLicenseNo(String licenseNo);

    @Query("SELECT d.id AS id, d.name AS name FROM Doctor d")
    List<DoctorDropdown> findAllDoctorDropdowns();
}
