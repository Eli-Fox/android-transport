
package com.lisway.transport.model.server.route;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Routes {

    @SerializedName("routes")
    private List<Route> routes = new ArrayList<>();
    @SerializedName("provider_attributes")
    private ProviderAttributes providerAttributes;

    /**
     * 
     * @return
     *     The routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * 
     * @param routes
     *     The routes
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    /**
     * 
     * @return
     *     The providerAttributes
     */
    public ProviderAttributes getProviderAttributes() {
        return providerAttributes;
    }

    /**
     * 
     * @param providerAttributes
     *     The provider_attributes
     */
    public void setProviderAttributes(ProviderAttributes providerAttributes) {
        this.providerAttributes = providerAttributes;
    }

}
