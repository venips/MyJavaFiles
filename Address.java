package entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	//addressID is Key Column(primary Key)
	@Id
	@GeneratedValue
	private int addressId;
	private String flatNo;
	private String streetName;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private int pin;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", streetName=" + streetName + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", country=" + country + ", pin=" + pin
				+ ", getAddressId()=" + getAddressId() + ", getFlatNo()=" + getFlatNo() + ", getStreetName()="
				+ getStreetName() + ", getLandmark()=" + getLandmark() + ", getCity()=" + getCity() + ", getState()="
				+ getState() + ", getCountry()=" + getCountry() + ", getPin()=" + getPin() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
     
}
