package com.lisway.transport.injection;

import android.content.Context;

import com.lisway.transport.provider.IRouteProvider;
import com.lisway.transport.provider.RouteProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RouteDrawingModule {
    private Context context;

    public RouteDrawingModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public IRouteProvider provideRouteDrawingManager(){
        return new RouteProvider(context);
    }
}
