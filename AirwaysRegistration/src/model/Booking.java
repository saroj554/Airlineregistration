package model;

public class Booking {
	private int flightid;
	private int userid;
	private String numberOfSeat;
	private String passengerName;
	private String passengerAge;
	private String passengerMobile;
	private String passengerEmail;

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerMobile() {
		return passengerMobile;
	}

	public void setPassengerMobile(String passengerMobile) {
		this.passengerMobile = passengerMobile;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(String numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}


	@Override
	public String toString() {
		return "Booking [passengerName=" + passengerName + ", passengerAge=" + passengerAge + ", passengerMobile="
				+ passengerMobile + ", passengerEmail=" + passengerEmail + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
