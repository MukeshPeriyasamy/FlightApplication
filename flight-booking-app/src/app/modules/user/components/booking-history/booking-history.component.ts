import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookedTicket } from '../../models/BookedTicket';
import { SearchTicketService } from '../../services/search-ticket.service';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.scss']
})
export class BookingHistoryComponent implements OnInit {
  // BookedFlightDetails
  searchHistory: FormGroup;
  response: BookedTicket[] = [];
  condition :boolean;
  displayedColumns: string[] = ['ticketId','airlineName', 'flightName', 'startPlace', 'endPlace', 'startTime', 'endTime', 'journeyDate', 'totalSeats','totalCost','status','getdetails'];
  

  constructor(private service: SearchTicketService,private router: Router) { 
    this.searchHistory = new FormGroup({
      ticketId: new FormControl("",[Validators.min(87450)]),
      email: new FormControl("",[Validators.email])
    })
    this.condition = false;
  }

  ngOnInit(): void {
  }
  public hasError = (controlName: string, errorName: string) =>{
    return this.searchHistory.controls[controlName].hasError(errorName);
  }
  search(){
    this.condition = false;
    this.response = [];
    if(this.searchHistory.value.ticketId > 0){
      let id:number = this.searchHistory.value.ticketId;
      this.service.searchTicketById(id.toString()).subscribe((res: any) => {
        this.response.push(res);
        if(res.ticket.status != "Active"){
          this.condition = true;
        }
      })
    }
    else if(this.searchHistory.value.email != null){
      this.service.searchTicketBymail(this.searchHistory.value.email).subscribe((res: any) => {
        this.response.push(res);
        if(res.ticket.status != "Active"){
          this.condition = true;
        }
      })
    }
    this.searchHistory.reset();
  }

  cancel(ticketId: number){
      console.log(ticketId + "cancelled");
      this.service.cancelTicket(this.response[0]).subscribe((res: any) => {
        if(res != null){
          window.alert("Your ticket number: " + res.ticket.ticketId + "has cancelled Successfully");
        }else{
          window.alert("Something went wrong :(");
        }
 
      let route = '/home';
      this.router.navigate([route]);
      })
  }
}
