import { Component, OnInit } from '@angular/core';
import { Observation } from '../models/observation';
import { ObservationService } from '../observation.service';

@Component({
  selector: 'app-observations',
  templateUrl: './observations.component.html',
  styleUrls: ['./observations.component.css']
})
export class ObservationsComponent implements OnInit{
  observations: Observation[] = []
  constructor(
    private observationService : ObservationService
  ) {    
  }
  ngOnInit(): void {
    //this.observationService.getAllStudent();
  }


}
