package com.filipense.filipense.controller;

import com.filipense.filipense.entity.HttpResponse;
import com.filipense.filipense.entity.Observation;
import com.filipense.filipense.entity.User;
import com.filipense.filipense.service.ObservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observations")
public class ObservationController
{
    @Autowired
    ObservationService observationService;

    @GetMapping("/listObservationsByEmployeeId/{employee_id}")
    public ResponseEntity<List<Observation>> listObservationsByEmployeeId(@PathVariable("employee_id") int employee_id) {
        return new ResponseEntity<>(observationService.listObservationsByEmployeeIdOrStudentId(employee_id, 0), HttpStatus.OK);
    }


    @GetMapping("/listObservationsByStudentId/{student_id}")
    public ResponseEntity<List<Observation>> listObservationsByStudentId(@PathVariable("student_id") int student_id) {
        return new ResponseEntity<>(observationService.listObservationsByEmployeeIdOrStudentId(0, student_id), HttpStatus.OK);
    }
    @GetMapping("/{observation_id}")
    public ResponseEntity<Observation> getObservationById(@PathVariable("observation_id") int observation_id){
        return observationService.getObservationById(observation_id)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createObservation")
    public ResponseEntity<HttpResponse> createObservation(@RequestBody Observation observation, HttpServletRequest request){
        HttpResponse response = new HttpResponse();
        //int activeUserId = userDetailServiceImplementation.userActive(request);
        //MODIFICAR AQUI ------>
        observation.setCreation_user_id(1);
        observation.setDependency_id(4);
        //--------->
        try{
            response.success = true;
            response.data = observationService.createObservation(observation);
            return new ResponseEntity<HttpResponse>(response, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            response.success = false;
            response.message= e.getMessage();
            return new ResponseEntity<HttpResponse>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/updateObservation/{observation_id}\"")
    public ResponseEntity<HttpResponse> updateObservation(@RequestBody Observation observation, @PathVariable("observation_id") int observation_id, HttpServletRequest request){
        HttpResponse response = new HttpResponse();
        //int activeUserId = userDetailServiceImplementation.userActive(request);
        User user = new User();

        user.setUser_id(1);
        user.setDependency_id(4);
        try{
            response.success = true;
            response.data = observationService.updateObservation(observation, user);
            return new ResponseEntity<HttpResponse>(response, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            response.success = false;
            response.message= e.getMessage();
            return new ResponseEntity<HttpResponse>(response, HttpStatus.OK);
        }
    }
}
