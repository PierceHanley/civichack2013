function markets(lat, lon) {
  $.ajax("/r/market/geo?lat=" + lat + "&lon=" + lon).done(function(obj) {
    $(obj.stations).each(function(o) {
      $('#map_canvas').gmap('addMarker', {
        'position' : new google.maps.LatLng(o.marketDetails.location.lat, o.marketDetails.location.lon),
        'bounds' : true
      }).click(function() {
        $('#map_canvas').gmap('openInfoWindow', {
          'content' : {
            o.marketDetails.products
            o.marketDetails.address
          }
        }, this);
      })
    })
  });
}
