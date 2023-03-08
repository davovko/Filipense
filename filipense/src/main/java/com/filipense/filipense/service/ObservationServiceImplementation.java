package com.filipense.filipense.service;

import com.filipense.filipense.entity.Observation;
import com.filipense.filipense.entity.User;
import com.filipense.filipense.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ObservationServiceImplementation implements ObservationService{
    @Autowired
    ObservationRepository observationRepository;

    @Override
    public Observation createObservation(Observation observation) {

        observation.setObservation(observation.getObservation().toUpperCase().trim());
        observation.setRecomendation(observation.getRecomendation().toUpperCase().trim());
        observation.setCreation_date(LocalDateTime.now());

        observation.setIdentification_number_visitor(observation.getIdentification_number_visitor() != null ? observation.getIdentification_number_visitor().toUpperCase().trim() : null);
        observation.setVisitor_name(observation.getVisitor_name() != null ? observation.getVisitor_name().toUpperCase().trim() : null);

        observation.setEvidence(observation.getEvidence().toUpperCase().trim());

        return observationRepository.save(observation);
    }

    @Override
    public Observation updateObservation(Observation observation, User user) {

        String message = observation.getDependency_id() != user.getDependency_id() ? "El usuario no puede modificar la observación. No pertenece a la misma dependencia" : "";

        if (message.isEmpty()){
            Optional<Observation> oldObservation = observationRepository.findById(observation.getObservation_id());
            Observation newObservation = oldObservation.get();

            newObservation.setReason_id(observation.getReason_id());
            newObservation.setObservation(observation.getObservation().trim().toUpperCase());
            newObservation.setObservation(observation.getObservation().toUpperCase().trim());
            newObservation.setRecomendation(observation.getRecomendation().toUpperCase().trim());
            newObservation.setModification_date(LocalDateTime.now());
            newObservation.setIdentification_number_visitor(observation.getIdentification_number_visitor() != null ? observation.getIdentification_number_visitor().toUpperCase().trim() : null);
            newObservation.setVisitor_name(observation.getVisitor_name() != null ? observation.getVisitor_name().toUpperCase().trim() : null);
            newObservation.setEvidence(observation.getEvidence().toUpperCase().trim());

            return observationRepository.save(newObservation);
        }
        throw new IllegalArgumentException(message);
    }

    @Override
    public Optional<Observation> getObservationById(int observation_id) {
        return observationRepository.findById(observation_id);
    }

    @Override
    public List<Observation> listObservationsByEmployeeIdOrStudentId(int employee_id, int student_id) {
        return employee_id != 0 ? observationRepository.findAllObservationsByEmployeeId(employee_id) : observationRepository.findAllObservationsByStudentId(student_id);
    }
}
