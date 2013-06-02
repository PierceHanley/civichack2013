package org.ph0.civichack.usda;

import javax.xml.bind.annotation.XmlRootElement;

import org.ph0.civichack.GeoCoordinate;

@XmlRootElement(name="marketdetails")
	public class MarketDetails {
//		@XmlElement(name="GoogleLink")
		private String googleLink;
		
//		@XmlElement(name="Address")
		private String address;

//		@XmlElement(name="Schedule")
		private String schedule;
		
//		@XmlElement(name="Products")
		private String products;
		
		private GeoCoordinate location;

		public String getGoogleLink() {
			return googleLink;
		}

		public void setGoogleLink(String googleLink) {
			this.googleLink = googleLink;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

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
					+ address + ", schedule=" + schedule + ", products="
					+ products + ", location=" + location + "]";
		}
		
		
	}