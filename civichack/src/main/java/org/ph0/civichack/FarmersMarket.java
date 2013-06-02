package org.ph0.civichack;

import javax.xml.bind.annotation.XmlRootElement;

import org.ph0.civichack.usda.MarketDetails;

@XmlRootElement
public class FarmersMarket {
	private String id;

//	@XmlElement(name = "marketname")
	private String marketName;

	private MarketDetails marketDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String name) {
		this.marketName = name;
	}

	public MarketDetails getMarketDetails() {
		return marketDetails;
	}

	public void setMarketDetails(MarketDetails marketDetails) {
		this.marketDetails = marketDetails;
	}

	@Override
	public String toString() {
		return "FarmersMarket [id=" + id + ", marketName=" + marketName
				+ ", marketDetails=" + marketDetails + "]";
	}

}
