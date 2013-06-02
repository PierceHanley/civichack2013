package org.ph0.civichack;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

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
}
