import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FlightSchedule } from '../models/flightSchedule';
import { LoginRequest } from '../models/loginRequest';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }

  searchTicket(request:LoginRequest){
    let host:string = "http://localhost:9090/authenticate/admin/login";
    return this.httpClient.post(host, request);
  }

  createSchedule(request:FlightSchedule,token:string){
    let host:string = "http://localhost:9090/api/v1/admin/schedule/add";
// console.log(localStorage.getItem("savedToken"));
console.log(token);
    let updatedToken:string = "Bearer " + token;
    const httpOptions = {
      headers: new HttpHeaders({      
        'Authorization': updatedToken
      })
    };
    return this.httpClient.post(host, request,httpOptions);
  }
}
