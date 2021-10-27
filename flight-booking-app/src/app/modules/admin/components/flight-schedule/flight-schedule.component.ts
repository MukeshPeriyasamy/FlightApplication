import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../../service/admin.service';
import { ErrorHandlerService } from '../../service/erro-handler.service';

@Component({
  selector: 'app-flight-schedule',
  templateUrl: './flight-schedule.component.html',
  styleUrls: ['./flight-schedule.component.scss']
})
export class FlightScheduleComponent implements OnInit {

  scheduleForm:FormGroup;
  token:string;
  public errorMessage: string = 'Something went wrong :(';
  constructor(private service: AdminService,private router: Router,private errorHandler: ErrorHandlerService) {
    this.scheduleForm = new FormGroup({
      airlineName: new FormControl("",[Validators.required]),
      flightName: new FormControl("",[Validators.required]),
      startPlace: new FormControl("",[Validators.required]),
      endPlace: new FormControl("",[Validators.required]),
      startTime: new FormControl("",[Validators.required]),
      endTime: new FormControl("",[Validators.required]),
      scheduleDay: new FormControl("",[Validators.required]),
      price: new FormControl("",[Validators.required])
    })
    this.token = history.state.data.token;
   }

  ngOnInit(): void {
  }

  addSchedule(){
    console.log(this.scheduleForm.value);
    this.service.createSchedule(this.scheduleForm.value,this.token).subscribe((res: any) => {
      console.log(res);
      window.alert("New flight Schedule was created Successfully!!! \n new Schudeule Id: " + res.id);
      // let route = '/admin/flightschedule';
      // this.router.navigate([route]);
      this.scheduleForm.reset();
    },
      (error: HttpErrorResponse) => {
      window.alert(this.errorMessage);
    })
  }
}
