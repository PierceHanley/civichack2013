package org.ph0.civichack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GeoService {
	private static final Logger log = LoggerFactory.getLogger(GeoService.class);
	private Client client;
	private ObjectMapper mapper;
	
	public GeoService() {

		ClientConfig cfg = new DefaultClientConfig();
		// cfg.getClasses().add(JacksonJsonProvider.class);
		client = Client.create(cfg);
		mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());
	}
	
	
	
	public GeoCoordinate fromGoogleLink(String url) {
		Pattern pattern = Pattern.compile("^http://maps\\.google\\.com/\\?.*q=([^%]+)%2C%20([^%]+).*$");
		Matcher matcher = pattern.matcher(url);
		if (!matcher.matches()) {
			return null;
		}
		
		String lat = matcher.group(1);
		String lon = matcher.group(2);
		
		GeoCoordinate ret = new GeoCoordinate();
		ret.setLat(lat);
		ret.setLon(lon);
		return ret;
	}
	
	public GeoCoordinate fromAddress(String address) throws Exception {

		String urlAddress = URLEncoder.encode(address);

		WebResource webResource = client
				.resource("https://maps.googleapis.com/maps/api/geocode/json?address=" + urlAddress + "&sensor=false");

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String body = response.getEntity(String.class);
		log.info(body);

		GeoCoordinate ret = new GeoCoordinate();
		JsonNode node = mapper.readTree(body);
		
		JsonNode loc = node.get("results").get(0).get("geometry").get("location");
		ret.setLat(loc.get("lat").asText());
		ret.setLon(loc.get("lng").asText());
		log.debug("Retrieved location {} from address \"{}\"", loc, address);
		return ret;
	}
}
