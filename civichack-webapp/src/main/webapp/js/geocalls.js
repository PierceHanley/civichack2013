function stations(lat, lon) {
	$.ajax("/r/bike/geo?lat=" + lat + "&lon=" + lon).done(function(obj) {
		console.log(obj.stations);
		$(obj.stations).each(function(o) {
			console.log("blah");
			$('#map_canvas').gmap('addMarker', {
				'position' : new google.maps.LatLng(o.lat, o.lon),
				'bounds' : true
			}).click(function() {
				$('#map_canvas').gmap('openInfoWindow', {
					'content' : o.name
				}, this);
			})
		})
	});

}