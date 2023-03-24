import { Component, OnInit } from '@angular/core';
import { ObservationService } from '../observation.service';

@Component({
  selector: 'app-observations',
  templateUrl: './observations.component.html',
  styleUrls: ['./observations.component.css']
})
export class ObservationsComponent implements OnInit{
  constructor(
    private observationService : ObservationService
  ) {    
  }
  ngOnInit(): void {
  }

}
