import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Observation } from './models/observation';

@Injectable({
  providedIn: 'root'
})
export class ObservationService {

  constructor(
    private http:  HttpClient
  ) { }

    getAllStudent(id: number){
      return this.http.get<Observation[]>('/api/observations/listObservationsByEmployeeId/' + id)
    }
    getAllEmployee(id: number){
      return this.http.get<Observation[]>('/api/observations/listObservationsByStudentId/' + id)
    }

    create(observation: any){
      return this.http.post<any>('/api/observations/createObservation', observation)
    }
    
    update({ id, observation }: { id: number; observation: any; }){
      return this.http.put<any>('/api/observations/updateObservation/' + id, observation)
    }
    delete(){}

}
