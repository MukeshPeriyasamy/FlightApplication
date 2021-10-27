export class SearchTicketRequest{
    constructor(
        public startPlace:string, 
        public endPlace:string, 
        public journeyDate:string
    ){}
}