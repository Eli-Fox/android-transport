package com.lisway.transport.screen.route;


import android.app.Activity;
import android.content.Intent;

import com.lisway.transport.api.ServiceFactory;
import com.lisway.transport.api.service.RouteService;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.model.server.route.Routes;
import com.lisway.transport.model.ui.route.RouteInfo;
import com.lisway.transport.screen.base.BasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RoutePresenter extends BasePresenter<RouteMvpView> {

    public static final String ROUTE_KEY = "ROUTE_KEY";

    private Activity activity;
    private RouteService routeService = ServiceFactory.newService(RouteService.class);
    private Subscription routesSubscription;
    private List<Route> routes;

    public RoutePresenter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void attachView(RouteMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        routeService = null;
        activity = null;
        if (routesSubscription != null) {
            routesSubscription.unsubscribe();
        }
    }

    public void requestRoutes() {
        routesSubscription = routeService.getRoutes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Routes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(Routes routes) {
                        if (routes != null) {
                            RoutePresenter.this.routes = routes.getRoutes();
                            getMvpView().showRoutes(RouteInfo.getRouteInfos(routes));
                        } else {
                            getMvpView().showError();
                        }
                    }
                });
    }

    public void drawRoute(int routePosition) {
        Intent data = new Intent();
        data.putExtra(ROUTE_KEY, routes.get(routePosition));
        activity.setResult(Activity.RESULT_OK, data);
        activity.finish();
    }
}