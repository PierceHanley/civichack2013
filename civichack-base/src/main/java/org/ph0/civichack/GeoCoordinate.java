package org.ph0.civichack;

public class GeoCoordinate {
	private String lat;
	private String lon;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Coordinate [lat=" + lat + ", lon=" + lon + "]";
	}

}