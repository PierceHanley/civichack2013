package org.ph0.civichack;

import org.junit.Assert;
import org.junit.Test;

public class GeoServiceTest {

	@Test
	public void testCoordFromGoogleLink() throws Exception {

		String link = "http://maps.google.com/?q=38.8048%2C%20-77.043%20(%22Alexandria+Farmers+Market%22)";
		GeoCoordinate coord = new GeoService().fromGoogleLink(link);
		Assert.assertTrue("38.8048".equals(coord.getLat()));
		Assert.assertTrue("-77.043".equals(coord.getLon()));
	}
	
	@Test
	public void testCoordFromAddress() throws Exception {
		String address = "301 King St., Market Square, Alexandria, Virginia, 22314";
		GeoCoordinate coord = new GeoService().fromAddress(address);
//		System.out.
		Assert.assertTrue("38.8".equals(coord.getLat().substring(0, 4)));
		Assert.assertTrue("-77.0".equals(coord.getLon().substring(0,5)));
		
	}
}
