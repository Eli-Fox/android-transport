package com.lisway.transport.screen.map;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.lisway.transport.R;
import com.lisway.transport.databinding.ActivityMapBinding;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.screen.base.BaseActivity;
import com.lisway.transport.screen.route.RouteActivity;
import com.lisway.transport.screen.route.RoutePresenter;
import com.lisway.transport.util.ViewUtil;

import java.util.List;

public class MapActivity extends BaseActivity implements MapMvpView, View.OnClickListener,
        TextView.OnEditorActionListener {

    private ActivityMapBinding binding;
    private MapPresenter presenter;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map);
        presenter = new MapPresenter(this);
        presenter.attachView(this);

        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RouteActivity.REQUEST_CODE) {
            Route route = (Route) data.getSerializableExtra(RoutePresenter.ROUTE_KEY);
            presenter.drawRoute(route);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_search:
                ViewUtil.hideKeyboard(this);
                presenter.requestRoutes(binding.editTextSearch.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return ViewUtil.onEditorDoneAction(actionId, binding.buttonSearch, this);
    }


    @Override
    public void showSearchError(int stringResourceId) {
        Snackbar.make(binding.getRoot(), stringResourceId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void clearMap() {
        map.clear();
    }

    @Override
    public void drawMarkers(List<MarkerOptions> markers) {
        for (MarkerOptions markerOptions : markers) {
            map.addMarker(markerOptions);
        }
    }

    @Override
    public void drawPolyLines(List<PolylineOptions> polyLines) {
        for (PolylineOptions polyline : polyLines) {
            map.addPolyline(polyline);
        }
    }

    @Override
    public void moveCamera(CameraUpdate camera) {
        map.moveCamera(camera);
    }

    private void initViews() {
        initGoogleMap();
        binding.buttonSearch.setOnClickListener(this);
        binding.editTextSearch.setOnEditorActionListener(this);
    }

    private void initGoogleMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                map.getUiSettings().setMapToolbarEnabled(false);
            }
        });
    }
}
