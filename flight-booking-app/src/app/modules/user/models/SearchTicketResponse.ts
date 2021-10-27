export class SearchTicketResponse{
    constructor(
        public id:number,
        public airlineName:string,
        public flightName:string,
        public startPlace:string, 
        public endPlace:string, 
        public startTime:string, 
        public endTime:string, 
        public journeyDate:string,
        public price:number,
        public availability:number
    ){}
}