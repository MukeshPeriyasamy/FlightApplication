import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookedTicket } from '../models/BookedTicket';
import { FlightTicket } from '../models/FlightTicket';
import { SearchTicketRequest } from '../models/SearchTicketRequest';

@Injectable({
  providedIn: 'root'
})
export class SearchTicketService {

  constructor(private httpClient:HttpClient) {}

   searchTicket(request:SearchTicketRequest){
    let host:string = "http://localhost:9090/api/v1/user/ticket/search";
    return this.httpClient.post(host, request);
  }

  bookTicket(request:FlightTicket){
    let host:string = "http://localhost:9090/api/v1/user/ticket/book";
    return this.httpClient.post(host, request);
  }

  searchTicketBymail(mail :string){
    let host:string = "http://localhost:9090/api/v1/user/ticket/email/" + mail;
    return this.httpClient.get(host);
  }

  searchTicketById(ticketId :string){
    let host:string = "http://localhost:9090/api/v1/user/ticket/" + ticketId;
    return this.httpClient.get(host);
  }

  cancelTicket(request:BookedTicket){
    let host:string = "http://localhost:9090/api/v1/user/ticket/cancel";
    return this.httpClient.post(host, request);
  }
}

