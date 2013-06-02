package org.ph0.civichack.bikeshare;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stations")
public class BikeshareStations {
	public static class Station {
		private String id;
		private String name;
		private double lat;
		private double lon;

		@XmlElement
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@XmlElement
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@XmlElement
		public Double getLat() {
			return lat;
		}

		public void setLat(Double lat) {
			this.lat = lat;
		}

		@XmlElement(name="long")
		public Double getLon() {
			return lon;
		}

		public void setLon(Double lon) {
			this.lon = lon;
		}

		@Override
		public String toString() {
			return "Station [id=" + id + ", name=" + name + ", lat=" + lat
					+ ", lon=" + lon + "]";
		}

	}
	
	private List<Station> stations;
	
	@XmlElement(name = "station")
	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "BikeshareStations [stations=" + stations + "]";
	}
	
	
}
