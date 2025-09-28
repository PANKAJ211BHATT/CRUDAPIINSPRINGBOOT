package com.bitGeeksCRUDAPI.CRUDAPI.Repository;

import com.bitGeeksCRUDAPI.CRUDAPI.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
