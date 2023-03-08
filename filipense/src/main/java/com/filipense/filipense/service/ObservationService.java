package com.filipense.filipense.service;
import com.filipense.filipense.entity.Observation;
import com.filipense.filipense.entity.User;

import java.util.List;
import java.util.Optional;

public interface ObservationService {
    public Observation createObservation(Observation observation);
    public Observation updateObservation(Observation observation, User user);
    public Optional<Observation> getObservationById(int observation_id);
    public List<Observation> listObservationsByEmployeeIdOrStudentId(int employee_id, int student_id);
}
