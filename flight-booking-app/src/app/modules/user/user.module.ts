import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchTicketComponent } from './components/search-ticket/search-ticket.component';
import { routes } from './user.routing';
import { RouterModule } from '@angular/router';
import { BookingHistoryComponent } from './components/booking-history/booking-history.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SearchTicketService } from './services/search-ticket.service';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { MatButtonModule } from  '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import { PassengerDetailsComponent } from './components/passenger-details/passenger-details.component';
import { BookedTicketComponent } from './components/booked-ticket/booked-ticket.component'


@NgModule({
  declarations: [
    SearchTicketComponent,
    BookingHistoryComponent,
    PassengerDetailsComponent,
    BookedTicketComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatTableModule,
    MatCardModule,
    MatRadioModule,
    MatSelectModule
  ],
  providers: [SearchTicketService]
})
export class UserModule { }
