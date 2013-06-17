package org.ph0.civichack;

import javax.xml.bind.JAXB;

import org.junit.Assert;
import org.junit.Test;
import org.ph0.civichack.bikeshare.BikeshareStations;
import org.ph0.civichack.bikeshare.BikeshareStations.Station;

public class BikeshareXmlTest {

	@Test
	public void testDeserializeXml() {
		BikeshareStations stns = JAXB.unmarshal(BikeshareXmlTest.class.getResource("/bikeStations.xml"),
				BikeshareStations.class);
		
		JAXB.marshal(stns, System.out);
	}
	
	@Test
	public void testDistance() {
//		List<Station> stations = Lists.newArrayList();
		Station s = new Station();
		s.setId("1");
		s.setLat(-1.0);
		s.setLon(-1.0);
		s.setName("station 1");
//		stations.add(s);
		
		Station s2 = new Station();
		s2.setId("2");
		s2.setLat(2.0);
		s2.setLon(2.0);
		s2.setName("station 2");
		
		Assert.assertTrue(new BikeshareService.StationComparator(0, 0).compare(s2, s) == 1);
	}
}
