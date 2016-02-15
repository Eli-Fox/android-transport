package com.lisway.transport.screen.route;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lisway.transport.R;
import com.lisway.transport.adapter.RouteAdapter;
import com.lisway.transport.databinding.ActivityRouteBinding;
import com.lisway.transport.listener.RecyclerOnItemClickListener;
import com.lisway.transport.model.ui.route.RouteInfo;
import com.lisway.transport.screen.base.BaseActivity;

import java.util.List;

public class RouteActivity extends BaseActivity implements RouteMvpView {

    public static final int REQUEST_CODE = 1245;

    private ActivityRouteBinding binding;
    private RoutePresenter presenter;
    private RouteAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_route);
        presenter = new RoutePresenter(this);
        presenter.attachView(this);

        initViews();
        presenter.requestRoutes();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showRoutes(List<RouteInfo> routeInfos) {
        adapter.setRoutes(routeInfos);
        adapter.notifyDataSetChanged();
        binding.progressBar.setVisibility(View.GONE);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        binding.progressBar.setVisibility(View.GONE);
        Snackbar.make(binding.getRoot(), R.string.route_error, Snackbar.LENGTH_LONG).show();
    }

    private void initViews() {
        binding.toolbar.toolbar.setTitle(R.string.route_title);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RouteAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.addOnItemTouchListener(new RecyclerOnItemClickListener(this,
                new RecyclerOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        presenter.drawRoute(position);
                    }
                }));
    }
}
