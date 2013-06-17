package org.ph0.civichack;

import static org.junit.Assert.*;

import javax.xml.bind.JAXB;

import org.junit.Test;
import org.ph0.civichack.bikeshare.BikeshareStations;

public class BikeshareServiceTest {

	@Test
	public void testBasilServiceCall() throws Exception {
		BikeshareService service = new BikeshareService();
		BikeshareStations stations = service.findStationsByGeoCoordinate(38.9065, -77.0453);
		assertNotNull(stations);
		assertTrue(stations.getStations().size() > 0);
		
		JAXB.marshal(stations, System.out);
	}
}
