package org.ph0.civichack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

public class HelloWorld {

	private FarmersMarketService service = new FarmersMarketService();
	private ObjectMapper mapper;
	
	public HelloWorld() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		HelloWorld hw = new HelloWorld();
		hw.outputMarkets("22314");
	}
	
	public void outputMarkets(String zip) throws Exception {
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
		writer.writeValue(System.out, service.findMarketsByZip("22314"));
//		List<FarmersMarket> markets = new FarmersMarketService().findMarketsByZip("22314");
//		for (FarmersMarket market : markets) {
//			market
//		}
	}

}
