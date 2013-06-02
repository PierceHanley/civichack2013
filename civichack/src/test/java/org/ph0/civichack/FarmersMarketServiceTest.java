package org.ph0.civichack;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.ph0.civichack.usda.FarmersMarket;

public class FarmersMarketServiceTest {

	private FarmersMarketService fm = new FarmersMarketService();
	private GeoService gs = new GeoService();
	
	@Test
	public void testMultipleEndpoints() throws Exception {
		List<FarmersMarket> markets = fm.findMarketsByZip("22314");
		FarmersMarket market = markets.get(0);
		GeoCoordinate coord = market.getMarketDetails().getLocation();
		List<FarmersMarket> newMarkets = fm.findMarketsByGeoCoordinate(coord);
//		Assert.assertTrue(false);
		Assert.assertEquals(market.toString(), newMarkets.get(0).toString());
	}
	
	@Test
	public void testFillDetails() throws Exception {
		FarmersMarket market = new FarmersMarket();
		market.setId("22006256");
		fm.fillMarketDetails(market);
		Assert.assertEquals(market.getMarketDetails().getGoogleLink(), "http://maps.google.com/?q=38.8048%2C%20-77.043%20(%22Alexandria+Farmers+Market%22)");
	}
}
