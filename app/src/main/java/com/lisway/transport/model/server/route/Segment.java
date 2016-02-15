
package com.lisway.transport.model.server.route;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Segment implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("num_stops")
    private Long numStops;
    @SerializedName("stops")
    private List<Stop> stops = new ArrayList<Stop>();
    @SerializedName("travel_mode")
    private String travelMode;
    @SerializedName("description")
    private Object description;
    @SerializedName("color")
    private String color;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("polyline")
    private String polyline;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The numStops
     */
    public Long getNumStops() {
        return numStops;
    }

    /**
     * 
     * @param numStops
     *     The num_stops
     */
    public void setNumStops(Long numStops) {
        this.numStops = numStops;
    }

    /**
     * 
     * @return
     *     The stops
     */
    public List<Stop> getStops() {
        return stops;
    }

    /**
     * 
     * @param stops
     *     The stops
     */
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    /**
     * 
     * @return
     *     The travelMode
     */
    public String getTravelMode() {
        return travelMode;
    }

    /**
     * 
     * @param travelMode
     *     The travel_mode
     */
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    /**
     * 
     * @return
     *     The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *     The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return
     *     The polyline
     */
    public String getPolyline() {
        return polyline;
    }

    /**
     * 
     * @param polyline
     *     The polyline
     */
    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

}
