package com.lisway.transport;

import android.app.Application;
import android.content.Context;

import com.lisway.transport.injection.DaggerMapPresenterComponent;
import com.lisway.transport.injection.MapPresenterComponent;
import com.lisway.transport.injection.RouteDrawingModule;

public class App extends Application {

    private static App context;
    private MapPresenterComponent mapPresenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        mapPresenterComponent = DaggerMapPresenterComponent
                .builder()
                .routeDrawingModule(new RouteDrawingModule(getApplicationContext()))
                .build();
    }

    public static App get() {
        return context;
    }

    public static MapPresenterComponent getMapPresenterComponent(Context context) {
        return ((App) context.getApplicationContext()).mapPresenterComponent;
    }

    public void setMapPresenterComponent(MapPresenterComponent mapPresenterComponent) {
        this.mapPresenterComponent = mapPresenterComponent;
    }
}
