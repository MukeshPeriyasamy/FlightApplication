import { Routes } from "@angular/router";
import { FlightScheduleComponent } from "./components/flight-schedule/flight-schedule.component";
import { LoginComponent } from "./components/login/login.component";

export const routes:Routes = [
    { path: "login", component: LoginComponent },
    { path: "flightschedule", component: FlightScheduleComponent }
]