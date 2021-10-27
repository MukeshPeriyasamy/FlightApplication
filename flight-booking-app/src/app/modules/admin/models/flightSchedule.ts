export class FlightSchedule{
    constructor(
        public airlineName:string,
        public flightName:string,
        public startPlace:string,
        public endPlace:string,
        public startTime:string,
        public endTime:string,
        public scheduleDay:string,
        public price:string,
        public availability:number
    ){}
}