package com.lisway.transport.injection;

import com.lisway.transport.screen.map.MapPresenter;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {RouteDrawingModule.class})
public interface MapPresenterComponent {
    void inject(MapPresenter mapPresenter);
}
