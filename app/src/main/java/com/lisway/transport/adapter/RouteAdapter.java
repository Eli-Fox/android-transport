package com.lisway.transport.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lisway.transport.R;
import com.lisway.transport.databinding.ItemRouteBinding;
import com.lisway.transport.model.ui.route.RouteInfo;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ProviderViewHolder> {
    private List<RouteInfo> routeInfos;

    public void setRoutes(List<RouteInfo> routeInfos) {
        this.routeInfos = routeInfos;
    }

    @Override
    public ProviderViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return ProviderViewHolder.create(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(ProviderViewHolder holder, int position) {
        holder.bindTo(routeInfos.get(position));
    }

    @Override
    public int getItemCount() {
        return routeInfos.size();
    }

    public static class ProviderViewHolder extends RecyclerView.ViewHolder {
        private ItemRouteBinding binding;

        public static ProviderViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemRouteBinding binding =
                    DataBindingUtil.inflate(inflater, R.layout.item_route, parent, false);
            return new ProviderViewHolder(binding);
        }

        private ProviderViewHolder(ItemRouteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(RouteInfo routeInfo) {
            binding.setItem(routeInfo);
        }
    }
}