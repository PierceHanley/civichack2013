

var curstations = []; 

function stations(lat, lon) {
	$.ajax("/r/bike/geo?lat=" + lat + "&lon=" + lon).done(function(obj) {
		console.log(obj.stations);
		$.each(obj.stations, function(index,o) {
			console.log("object: " ,o);
			var curstation = $('#map_canvas').gmap('addMarker', {
				'position' : new google.maps.LatLng(o.lat, o.lon),
				'icon': "http://www.google.com/intl/en_us/mapfiles/ms/micons/green-dot.png",
				'bounds' : true
			}).click(function() {
				$('#map_canvas').gmap('openInfoWindow', {
					'content' : o.name
				}, this);
			});
			curstations.push(curstation);
		});

		
	});

}

function markets(lat, lon) {
	$.ajax("/r/market/geo?lat=" + lat + "&lon=" + lon).done(function(obj) {
		console.log(obj);
		$.each(obj, function(index,o) {
			console.log("object: " ,o);
			var curmarker = $('#map_canvas').gmap('addMarker', {
				'position' : new google.maps.LatLng(o.marketDetails.location.lat, o.marketDetails.location.lon),
				'bounds' : true,
				'icon': "http://www.google.com/intl/en_us/mapfiles/ms/micons/blue-dot.png"
			}).click(function() {
				$.each(curstations, function(i, o) {
					o.setVisible(false);
				});
				curstations = [];
				$('#map_canvas').gmap('openInfoWindow', {
					'content' : o.marketName
				}, this);
				stations(lat,lon);
			});
		})
	});

}