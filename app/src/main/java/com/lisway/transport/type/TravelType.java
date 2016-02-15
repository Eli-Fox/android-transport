package com.lisway.transport.type;

import android.graphics.Color;

import com.lisway.transport.R;

public enum TravelType {
    WALKING("walking", Color.GREEN, R.string.map_walking),
    SUBWAY("subway", Color.MAGENTA, R.string.map_subway),
    BUS("bus", Color.GRAY, R.string.map_bus),
    CHANGE("change", Color.BLUE, R.string.map_change),
    SETUP("setup", Color.RED, R.string.map_setup),
    DRIVING("driving", Color.YELLOW, R.string.map_driving),
    PARKING("parking", Color.WHITE, R.string.map_parking),
    CYCLING("cycling", Color.CYAN, R.string.map_cycling);

    private String value;
    private int mapDrawingColor;
    private int titleResourceId;

    TravelType(String value, int mapDrawingColor, int titleResourceId) {
        this.value = value;
        this.mapDrawingColor = mapDrawingColor;
        this.titleResourceId = titleResourceId;
    }

    public String getValue() {
        return value;
    }

    public int getMapDrawingColor() {
        return mapDrawingColor;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public static TravelType getType(String value) {
        TravelType travelType = null;
        for (TravelType type : values()) {
            if (value.equalsIgnoreCase(type.getValue())) {
                travelType = type;
                break;
            }
        }
        return travelType;
    }
}
