package com.lisway.transport.provider;

import android.content.Context;
import android.text.TextUtils;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import com.google.maps.android.ui.IconGenerator;
import com.lisway.transport.R;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.model.server.route.Segment;
import com.lisway.transport.model.server.route.Stop;
import com.lisway.transport.type.TravelType;

import java.util.ArrayList;
import java.util.List;

public class RouteProvider implements IRouteProvider {
    private static final int POLYLINE_WIDTH = 10;
    private static final int STARTING_MAP_ZOOM = 13;
    private static final int CONTENT_ROTATION = -90;
    private static final int ROTATION = 90;

    private final IconGenerator iconFactory;
    private Context context;

    public RouteProvider(Context context) {
        this.context = context;
        iconFactory = new IconGenerator(context);
        iconFactory.setContentRotation(CONTENT_ROTATION);
        iconFactory.setRotation(ROTATION);
        iconFactory.setStyle(IconGenerator.STYLE_DEFAULT);
    }

    @Override
    public List<MarkerOptions> getMarkers(Route route) {
        List<MarkerOptions> markers = new ArrayList<>();

        List<Segment> segments = route.getSegments();
        Stop firstStop = segments.get(0).getStops().get(0);
        Stop lastStop = segments.get(segments.size() - 1).getStops()
                .get(segments.get(segments.size() - 1).getStops().size() - 1);

        markers.add(getMajorMarker(firstStop, R.string.map_start));
        for (Segment segment : segments) {
            if (!segment.getTravelMode().equalsIgnoreCase(TravelType.CHANGE.getValue())) {
                markers.add(getChangeSegmentMarker(segment));
            }
        }
        markers.add(getMajorMarker(lastStop, R.string.map_finish));

        return markers;
    }

    @Override
    public List<PolylineOptions> getPolyLines(List<Segment> segments) {
        List<PolylineOptions> polyLines = new ArrayList<>();

        for (Segment segment : segments) {
            if (TextUtils.isEmpty(segment.getPolyline())) {
                continue;
            }

            PolylineOptions polyline = createPolyline(segment.getTravelMode());
            List<LatLng> polylinePoints = PolyUtil.decode(segment.getPolyline());
            for (LatLng newPolylinePoint : polylinePoints) {
                polyline.add(newPolylinePoint);
            }

            polyLines.add(polyline);
        }

        return polyLines;
    }

    @Override
    public CameraUpdate getCamera(Route route) {
        Stop firstStop = route.getSegments().get(0).getStops().get(0);
        return CameraUpdateFactory.newLatLngZoom(
                new LatLng(firstStop.getLat(), firstStop.getLng()), STARTING_MAP_ZOOM);
    }

    private MarkerOptions getMajorMarker(Stop stop, int titleResourceId) {
        return new MarkerOptions()
                .position(new LatLng(stop.getLat(), stop.getLng()))
                .title(context.getString(titleResourceId));
    }

    private MarkerOptions getChangeSegmentMarker(Segment segment) {
        Stop stop = segment.getStops().get(0);
        LatLng point = new LatLng(stop.getLat(), stop.getLng());
        TravelType travelType = TravelType.getType(segment.getTravelMode());

        return new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(
                        context.getString(travelType.getTitleResourceId()))))
                .position(point)
                .anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());
    }

    private PolylineOptions createPolyline(String travelTypeString) {
        TravelType travelType = TravelType.getType(travelTypeString);

        return new PolylineOptions()
                .width(POLYLINE_WIDTH)
                .geodesic(true)
                .color(travelType.getMapDrawingColor());
    }
}
