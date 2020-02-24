package FlightManagementSystem.Dto;

public class FlightDto {
private long flightNumber;
private String flightModel;
private String carrierName ;
private int seatCapacity;
/*----------------------------------------------------Constructor------------------------------------------------------*/
public FlightDto() {
	super();
	
}

/*----------------------------------------------------Getter and Setter-------------------------------------------------------*/
public long getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(long flightNumber) {
	this.flightNumber = flightNumber;
}
public String getFlightModel() {
	return flightModel;
}
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
public String getCarrierName() {
	return carrierName;
}
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
public int getSeatCapacity() {
	return seatCapacity;
}
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
/*----------------------------------------------------toString() method-------------------------------------------------------*/

@Override
public String toString() {
	return "FlightDto [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
			+ ", seatCapacity=" + seatCapacity + "]";
}

}
