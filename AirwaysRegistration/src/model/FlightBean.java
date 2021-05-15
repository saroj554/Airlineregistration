package model;


public class FlightBean {

	private int flightid;
	private String flightName;
	private String price;
	private String source;
	private String destination;
	private String flightDate;
	private String totalSeat;
	private String abvailableSeat;
	
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(String totalSeat) {
		this.totalSeat = totalSeat;
	}
	public String getAbvailableSeat() {
		return abvailableSeat;
	}
	public void setAbvailableSeat(String abvailableSeat) {
		this.abvailableSeat = abvailableSeat;
	}
	@Override
	public String toString() {
		return "FlightBean [flightid=" + flightid + ", flightName=" + flightName + ", price=" + price + ", source="
				+ source + ", destination=" + destination + ", flightDate=" + flightDate + ", totalSeat=" + totalSeat
				+ ", abvailableSeat=" + abvailableSeat + "]";
	}

	

}
