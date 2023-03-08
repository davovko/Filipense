package com.filipense.filipense.repository;

import com.filipense.filipense.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer> {
    @Query(value = "SELECT * FROM observation WHERE employee_id = :employeeId", nativeQuery = true)
    public List<Observation> findAllObservationsByEmployeeId(@Param("employeeId") int employee_id);
    @Query(value = "SELECT * FROM observation WHERE student_id = :studentId", nativeQuery = true)
    public List<Observation> findAllObservationsByStudentId(@Param("studentId") int student_id);
}
