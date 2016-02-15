package com.lisway.transport.api.service;

import com.lisway.transport.model.server.route.Routes;

import retrofit.http.GET;
import rx.Observable;

public interface RouteService {

    @GET("56c07942270000f839cc4201")
    Observable<Routes> getRoutes();
}
