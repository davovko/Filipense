package com.filipense.filipense.repository;

import com.filipense.filipense.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM person WHERE identification_number = :identification_number AND identification_type_id = :identification_type_id", nativeQuery = true)
    public Person findPersonByIdentificationNumber(@Param("identification_number") String identification_number, @Param("identification_type_id") int identification_type_id);

    @Query(value = "SELECT * FROM person WHERE email = :email", nativeQuery = true)
    public Person findPersonByEmail(@Param("email") String email);
}
