package com.hms.profile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hms.profile.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
