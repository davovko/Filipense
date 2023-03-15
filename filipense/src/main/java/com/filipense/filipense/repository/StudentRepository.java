package com.filipense.filipense.repository;

import com.filipense.filipense.entity.Student;
import com.filipense.filipense.entity.StudentPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student WHERE student_code = :studentCode", nativeQuery = true)
    public Student getStudentByCode(@Param("studentCode") String student_code);

    @Query(value = "SELECT * \n" +
                    "FROM person \n" +
                    "INNER JOIN student\n" +
                    "ON student.person_id = person.person_id\n" +
                    "WHERE student.student_id = :studentid", nativeQuery = true)
    public Object[][] getStudentPerson(@Param("studentid") int student_id);
}
