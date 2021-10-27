import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { FlightTicket } from '../../models/FlightTicket';
import { Passenger } from '../../models/Passenger';
import { SearchTicketResponse } from '../../models/SearchTicketResponse';
import { TicketDetails } from '../../models/TicketDetails';
import { SearchTicketService } from '../../services/search-ticket.service';

@Component({
  selector: 'app-passenger-details',
  templateUrl: './passenger-details.component.html',
  styleUrls: ['./passenger-details.component.scss']
})
export class PassengerDetailsComponent implements OnInit {
  inputValue = 0;
  totalCost: number;
  ticketDetails: FormGroup;
  passengerForm: FormGroup;
  passengers: Passenger[] = [];
  displayedColumns: string[] = ['seatNo', 'name', 'sex', 'age', 'meal'];
  selectedJourney: SearchTicketResponse;
  num: number = 0;
  constructor(private service: SearchTicketService, private router: Router) {
    this.selectedJourney = history.state.data.selected;
    this.passengerForm = new FormGroup({
      seatNo: new FormControl(),
      name: new FormControl(),
      sex: new FormControl(),
      age: new FormControl(),
      meal: new FormControl()
    })
    this.ticketDetails = new FormGroup({
      userName: new FormControl(),
      email: new FormControl(),
      totalSeats: new FormControl(),
      totalCost: new FormControl()
    })
    this.totalCost = this.selectedJourney.price;
  }

  ngOnInit(): void {

  }

  onChangeEvent(event: any) {
    this.num = event.target.value;
    this.totalCost = this.selectedJourney.price * this.num;
  }

  addPassenger() {
    this.passengers.push(this.passengerForm.value);
    this.passengerForm.reset();
  }

  finalSubmit() {
    let ticket: TicketDetails = new TicketDetails(this.selectedJourney.airlineName, this.selectedJourney.flightName, this.selectedJourney.startPlace, this.selectedJourney.endPlace, this.selectedJourney.startTime, this.selectedJourney.endTime, this.selectedJourney.journeyDate, this.ticketDetails.value.userName, this.ticketDetails.value.email, this.ticketDetails.value.totalSeats, this.ticketDetails.value.totalCost, this.selectedJourney.id)
    let flightTicket: FlightTicket = new FlightTicket(ticket, this.passengers);
    console.log(flightTicket);
    this.service.bookTicket(flightTicket).subscribe((res: any) => {
      console.log("AfterBooking");
      window.alert("Your Ticket has booked Successfully!!! \n Your ticket number: " + res.ticket.ticketId);
      let route = '/home';
      this.router.navigate([route]);
    })
  }

}
