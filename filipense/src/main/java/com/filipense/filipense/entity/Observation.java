package com.filipense.filipense.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "observation")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int observation_id;
    private Integer employee_id = null;
    private Integer student_id = null;
    private int dependency_id;
    private int reason_id;
    private String observation;
    private String recomendation;
    private LocalDateTime creation_date = LocalDateTime.now();
    private LocalDateTime modification_date = null;
    private Integer relationship_id = null;
    private Integer identificationtype_id = null;
    private String identification_number_visitor = null;
    private String visitor_name = null;
    private String evidence = null;
    private int creation_user_id;
    private Integer modification_user_id = null;

    public Observation() {
    }

    public int getObservation_id() {
        return observation_id;
    }

    public void setObservation_id(int observation_id) {
        this.observation_id = observation_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public int getDependency_id() {
        return dependency_id;
    }

    public void setDependency_id(int dependency_id) {
        this.dependency_id = dependency_id;
    }

    public int getReason_id() {
        return reason_id;
    }

    public void setReason_id(int reason_id) {
        this.reason_id = reason_id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getModification_date() {
        return modification_date;
    }

    public void setModification_date(LocalDateTime modification_date) {
        this.modification_date = modification_date;
    }

    public Integer getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(Integer relationship_id) {
        this.relationship_id = relationship_id;
    }

    public Integer getIdentificationtype_id() {
        return identificationtype_id;
    }

    public void setIdentificationtype_id(Integer identificationtype_id) {
        this.identificationtype_id = identificationtype_id;
    }

    public String getIdentification_number_visitor() {
        return identification_number_visitor;
    }

    public void setIdentification_number_visitor(String identification_number_visitor) {
        this.identification_number_visitor = identification_number_visitor;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public int getCreation_user_id() {
        return creation_user_id;
    }

    public void setCreation_user_id(int creation_user_id) {
        this.creation_user_id = creation_user_id;
    }

    public Integer getModification_user_id() {
        return modification_user_id;
    }

    public void setModification_user_id(Integer modification_user_id) {
        this.modification_user_id = modification_user_id;
    }
}
