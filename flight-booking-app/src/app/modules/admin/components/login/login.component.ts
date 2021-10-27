import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../../service/admin.service';
import { ErrorHandlerService } from '../../service/erro-handler.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup;
  hide = true;
  public errorMessage: string = '';
  constructor(private service: AdminService,private router: Router,private errorHandler: ErrorHandlerService) { 
    this.loginForm = new FormGroup({
      username: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required])
    })
  }

  ngOnInit(): void {
  }
 
  submit(){
    console.log(this.loginForm.value);
    this.service.searchTicket(this.loginForm.value).subscribe((res: any) => {
      let token:string = res;
      localStorage.setItem("savedToken", token);
      let route = '/admin/flightschedule';
      this.router.navigate([route],{state: {data: {token}}});
    },
      (error) => {
        console.log(error.error.message);
        window.alert(error.error.message);
      })
  }
}
