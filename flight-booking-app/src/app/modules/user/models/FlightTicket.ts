import { Passenger } from "./Passenger";
import { TicketDetails } from "./TicketDetails";

export class FlightTicket{
    constructor(
        public ticket:TicketDetails,
        public passenger:Passenger[]
    ){}
}