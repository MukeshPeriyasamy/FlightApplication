import { HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {
  public errorMessage: string = '';
 
  constructor(private router: Router) { }
 
  public handleError = (error: HttpErrorResponse) => {
    this.errorMessage = error.error ? error.error : error.message;
  }
}
