package com.lisway.transport.model.ui.route;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.caverock.androidsvg.SVG;
import com.lisway.transport.App;
import com.lisway.transport.R;
import com.lisway.transport.model.server.route.Provider;
import com.lisway.transport.model.server.route.Route;
import com.lisway.transport.model.server.route.Routes;
import com.lisway.transport.type.ProviderType;
import com.lisway.transport.util.svg.Svg;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RouteInfo extends BaseObservable {

    private static final float CENTS = 100f;

    private String name;
    private String price;
    private String svgIconUrl;

    public RouteInfo(String name, String price, String svgIconUrl) {
        this.name = name;
        this.price = price;
        this.svgIconUrl = svgIconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSvgIconUrl() {
        return svgIconUrl;
    }

    public void setSvgIconUrl(String svgIconUrl) {
        this.svgIconUrl = svgIconUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void setImageUrl(ImageView view, String url) {
        if (!TextUtils.isEmpty(url)) {
            GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder
                    = Svg.getBuilder(view.getContext());

            requestBuilder.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .load(Uri.parse(url))
                    .into(view);
        }
    }

    public static List<RouteInfo> getRouteInfos(@NonNull Routes routesInfo) {
        List<Route> routes = routesInfo.getRoutes();
        List<RouteInfo> routeInfos = new ArrayList<>(routes.size());
        for (Route route : routes) {
            Provider provider = ProviderType.getProvider(route.getProvider(),
                    routesInfo.getProviderAttributes());
            float euroPrice = route.getPrice() != null ? route.getPrice().getAmount() / CENTS : 0;
            String name = provider.getDisplayName();

            if (TextUtils.isEmpty(name)) {
                name = provider.getDisclaimer();
            }

            routeInfos.add(new RouteInfo(name,
                    App.get().getString(R.string.route_price_pattern, euroPrice),
                    provider.getProviderIconUrl()));
        }

        return routeInfos;
    }
}
