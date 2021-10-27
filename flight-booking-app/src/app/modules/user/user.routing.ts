import { Routes } from "@angular/router";
import { BookedTicketComponent } from "./components/booked-ticket/booked-ticket.component";
import { BookingHistoryComponent } from "./components/booking-history/booking-history.component";
import { PassengerDetailsComponent } from "./components/passenger-details/passenger-details.component";
import { SearchTicketComponent } from "./components/search-ticket/search-ticket.component";
import { BookedTicket } from "./models/BookedTicket";

export const routes:Routes = [
    { path: "searchticket", component: SearchTicketComponent },
    { path: "bookinghistory", component: BookingHistoryComponent },
    { path: "passengerdetails", component: PassengerDetailsComponent },
    { path: "ticketdetails", component: BookedTicketComponent }
]