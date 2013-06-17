package org.ph0.civichack.usda;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.ph0.civichack.GeoCoordinate;

@XmlRootElement(name = "marketdetails")
public class MarketDetails {
	private String googleLink;

	private String address;

	private String schedule;

	private String products;

	private GeoCoordinate location;

	@XmlElement(name = "GoogleLink", required = false)
	public String getGoogleLink() {
		return googleLink;
	}

	public void setGoogleLink(String googleLink) {
		this.googleLink = googleLink;
	}

	@XmlElement(name = "Address", required = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "Schedule", required = false)
	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@XmlElement(name = "Products", required = false)
	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public GeoCoordinate getLocation() {
		return location;
	}

	public void setLocation(GeoCoordinate location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "MarketDetails [googleLink=" + googleLink + ", address="
				+ address + ", schedule=" + schedule + ", products=" + products
				+ ", location=" + location + "]";
	}

}