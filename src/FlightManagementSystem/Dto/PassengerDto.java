package FlightManagementSystem.Dto;

public class PassengerDto {
	
private long pnrNumber;
private String passengerName;
private int passengerAge;
private long passengerUIN;
private double luggage;
private long bookingId;

public long getBookingId() {
	return bookingId;
}
public void setBookingId(long bookingId) {
	this.bookingId = bookingId;
}
/*---------------------------------------------Constructor---------------------------------------------------------*/
public PassengerDto() {
	super();

}
/*------------------------------------------------------GETTER AND SETTER-------------------------------------------*/
public long getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(long pnrNumber) {
	this.pnrNumber = pnrNumber;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getPassengerAge() {
	return passengerAge;
}
public void setPassengerAge(int passengerAge) {
	this.passengerAge = passengerAge;
}
public long getPassengerUIN() {
	return passengerUIN;
}
public void setPassengerUIN(long passengerUIN) {
	this.passengerUIN = passengerUIN;
}
public double getLuggage() {
	return luggage;
}
public void setLuggage(double luggage) {
	this.luggage = luggage;
}
/*----------------------------------------------------toString() method-------------------------------------------------------*/
@Override
public String toString() {
	return "PassengerDto [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
			+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
}


}
