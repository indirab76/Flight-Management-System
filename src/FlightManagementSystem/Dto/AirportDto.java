package FlightManagementSystem.Dto;

public class AirportDto {
 private String airportCode;
 private String airportName;
 private String airportLocation;
 
 /*---------------------------------------------Constructor---------------------------------------------------------*/
public AirportDto() {
	super();
	
}
/*----------------------------------------------GETTER AND SETTER---------------------------------------------------------*/
public String getAirportCode() {
	return airportCode;
}
public void setAirportCode(String airportCode) {
	this.airportCode = airportCode;
}
public String getAirportName() {
	return airportName;
}
public void setAirportName(String airportName) {
	this.airportName = airportName;
}
public String getAirportLocation() {
	return airportLocation;
}
public void setAirportLocation(String airportLocation) {
	this.airportLocation = airportLocation;
}
/*---------------------------------------------toString() method ---------------------------------------------------------*/
@Override
public String toString() {
	return "AirportDto [airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation="
			+ airportLocation + "]";
}

}
