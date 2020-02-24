package FlightManagementSystem.Dto;

import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.time.*;
import FlightManagementSystem.Dto.PassengerDto;
public class BookingDto {
	
private long bookingId; 
private long userId;
private java.sql.Date bookingDate;
private double ticketCost;
private long flightNumber;
private int noOfPassengers;
private long scheduleid;

/*-----------------------------------------------Constructor------------------------------------------------------------------*/
public BookingDto() {
	super();
	
}
/*-----------------------------------------Getter and Setter---------------------------------------------------------*/
public long getBookingId() {
	return bookingId;
}
public void setBookingId(long bookingId) {
	this.bookingId = bookingId;
}
public long getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(long flightNumber) {
	this.flightNumber = flightNumber;
}
public long getScheduleid() {
	return scheduleid;
}
public void setScheduleid(long scheduleid) {
	this.scheduleid = scheduleid;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public java.sql.Date getBookingDate() {
	return bookingDate;
}
public void setBookingDate(Date date) {
	this.bookingDate = (java.sql.Date) date;
}
public double getTicketCost() {
	return ticketCost;
}
public void setTicketCost(double ticketCost) {
	this.ticketCost = ticketCost;
}
public int getNoOfPassengers() {
	return noOfPassengers;
}
public void setNoOfPassengers(int noOfPassengers) {
	this.noOfPassengers = noOfPassengers;
}

/*------------------------------------------------toString() method ------------------------------------------------------*/
@Override
public String toString() {
	return "BookingDto [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
			+ ", ticketCost=" + ticketCost + ", flight=" + flightNumber + ", noOfPassengers=" + noOfPassengers +"]";
}

}
