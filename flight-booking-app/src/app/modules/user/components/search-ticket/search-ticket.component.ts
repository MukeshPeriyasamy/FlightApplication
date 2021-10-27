import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SearchTicketRequest } from '../../models/SearchTicketRequest';
import { SearchTicketResponse } from '../../models/SearchTicketResponse';
import { SearchTicketService } from '../../services/search-ticket.service';

@Component({
  selector: 'app-search-ticket',
  templateUrl: './search-ticket.component.html',
  styleUrls: ['./search-ticket.component.scss']
})
export class SearchTicketComponent implements OnInit {

  searchForm: FormGroup;
  response: SearchTicketResponse[] = [];
  displayedColumns: string[] = ['airlineName', 'flightName', 'startPlace', 'endPlace', 'startTime', 'endTime', 'journeyDate', 'price', 'availability'];
  clickedRows = new Set<SearchTicketResponse>();
  constructor(private service: SearchTicketService,private router: Router) {
    this.searchForm = new FormGroup({
      startPlace: new FormControl("", Validators.required),
      endPlace: new FormControl("", Validators.required),
      journeyDate: new FormControl("", Validators.required)
    })
  }

  ngOnInit(): void {
  }

  search() {
    this.response = []
    if (this.searchForm.valid) {
      let req = new SearchTicketRequest(this.searchForm.value.startPlace, this.searchForm.value.endPlace, this.searchForm.value.journeyDate);
      this.service.searchTicket(req).subscribe((res: any) => {
        this.response = res;
      })
    }
  }

  selectedJourney(selected: SearchTicketResponse){
    console.log("+++++=====================+++++");
    console.log(selected);
    let route = '/user/passengerdetails';
    this.router.navigate([route],{state: {data: {selected}}});
  }

}