package com.lisway.transport.provider;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.model.server.route.Segment;

import java.util.List;


public interface IRouteProvider {
    List<MarkerOptions> getMarkers(Route route);
    List<PolylineOptions> getPolyLines(List<Segment> segments);
    CameraUpdate getCamera(Route route);
}
