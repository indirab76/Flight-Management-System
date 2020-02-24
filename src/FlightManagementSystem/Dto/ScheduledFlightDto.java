package FlightManagementSystem.Dto;

import java.sql.Date;

public class ScheduledFlightDto {
private long scheduleId ;
private long flightNumber;
private int availableSeats;
private Date arrivalTime;
private Date departureTime;
private Date boardingDate;
private String sourceAirport_code;
private String destinationAirport_code;
private float ticketCost;

/*-----------------------------------------------------Constructor--------------------------------------------------------*/
public ScheduledFlightDto() {
	super();
	
}
/*---------------------------------------------------Getter and Setter------------------------------------------------------*/
public long getFlight() {
	return flightNumber;
}
public void setFlight(long flight) {
	this.flightNumber = flight;
}
public float getTicketCost() {
	return ticketCost;
}
public void setTicketCost(float ticketCost) {
	this.ticketCost = ticketCost;
}
public long getScheduleId() {
	return scheduleId;
}
public Date getBoardingDate() {
	return boardingDate;
}
public void setBoardingDate(Date boardingDate) {
	this.boardingDate = boardingDate;
}
public void setScheduleId(long scheduleId) {
	this.scheduleId = scheduleId;
}
public int getAvailableSeats() {
	return availableSeats;
}
public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
}
public Date getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(Date arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public Date getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(Date departureTime) {
	this.departureTime = departureTime;
}
public String getSourceAirport() {
	return sourceAirport_code;
}
public void setSourceAirport(String sourceAirport) {
	this.sourceAirport_code = sourceAirport;
}
public String getDestinationAirport() {
	return destinationAirport_code;
}
public void setDestinationAirport(String destinationAirport) {
	this.destinationAirport_code = destinationAirport;
}
/*--------------------------------------toString() method--------------------------------------------------------------*/
@Override
public String toString() {
	return "ScheduledFlightDto [scheduleId=" + scheduleId + ", flight=" + flightNumber + ", availableSeats=" + availableSeats
			+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", boardingDate=" + boardingDate
			+ ", sourceAirport=" + sourceAirport_code + ", destinationAirport=" + destinationAirport_code + ", ticketCost="
			+ ticketCost + "]";
}





}
