package com.lisway.transport.screen.map;


import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.lisway.transport.App;
import com.lisway.transport.R;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.provider.IRouteProvider;
import com.lisway.transport.screen.base.BasePresenter;
import com.lisway.transport.screen.route.RouteActivity;

import java.util.List;

import javax.inject.Inject;

public class MapPresenter extends BasePresenter<MapMvpView> {

    @Inject
    public IRouteProvider routeProvider;
    private Activity activity;

    public MapPresenter(Activity activity) {
        this.activity = activity;
        App.getMapPresenterComponent(activity).inject(this);
    }

    @Override
    public void attachView(MapMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        routeProvider = null;
        activity = null;
    }

    public void requestRoutes(String destination) {
        checkViewAttached();

        if (!TextUtils.isEmpty(destination)) {
            Intent intent = new Intent(activity, RouteActivity.class);
            activity.startActivityForResult(intent, RouteActivity.REQUEST_CODE);
        } else {
            getMvpView().showSearchError(R.string.map_search_error);
        }
    }

    public void drawRoute(Route route) {
        checkViewAttached();

        List<MarkerOptions> markers = routeProvider.getMarkers(route);
        List<PolylineOptions> polyLines = routeProvider.getPolyLines(route.getSegments());
        CameraUpdate cameraUpdate = routeProvider.getCamera(route);

        getMvpView().clearMap();
        getMvpView().drawMarkers(markers);
        getMvpView().drawPolyLines(polyLines);
        getMvpView().moveCamera(cameraUpdate);
    }
}