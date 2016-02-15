package com.lisway.transport.api.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.lisway.transport.api.gson.serializer.MillisecondsDateAdapter;

import java.util.Date;

public class GsonWrapper {
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getAnnotation(Expose.class) != null;
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
                .registerTypeAdapter(Date.class, new MillisecondsDateAdapter())
                .registerTypeAdapter(java.sql.Date.class, new MillisecondsDateAdapter())
                .create();
        }
        return gson;
    }
}
