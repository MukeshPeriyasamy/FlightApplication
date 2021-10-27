import { Passenger } from "./Passenger";
import { BookedFlightDetails } from "./BookedFlightDetails";

export class BookedTicket{
    constructor(
        public ticket:BookedFlightDetails,
        public passenger:Passenger[]
    ){}
}