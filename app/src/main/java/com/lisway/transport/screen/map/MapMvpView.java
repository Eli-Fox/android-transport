package com.lisway.transport.screen.map;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.lisway.transport.screen.base.MvpView;

import java.util.List;

public interface MapMvpView extends MvpView {
    void showSearchError(int stringResourceId);
    void clearMap();
    void drawMarkers(List<MarkerOptions> markers);
    void drawPolyLines(List<PolylineOptions> polylines);
    void moveCamera(CameraUpdate camera);
}
