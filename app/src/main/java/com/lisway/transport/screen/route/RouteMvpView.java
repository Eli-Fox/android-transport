package com.lisway.transport.screen.route;


import com.lisway.transport.model.ui.route.RouteInfo;
import com.lisway.transport.screen.base.MvpView;

import java.util.List;

public interface RouteMvpView extends MvpView {
    void showRoutes(List<RouteInfo> routeInfos);
    void showError();
}
