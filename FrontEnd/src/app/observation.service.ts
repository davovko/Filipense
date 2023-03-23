import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ObservationService {

  constructor(
    private http:  HttpClient
  ) { }

    getAll(){

    }

    create(){}
    update(){}
    delete(){}

}
