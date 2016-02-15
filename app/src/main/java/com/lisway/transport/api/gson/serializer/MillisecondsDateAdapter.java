package com.lisway.transport.api.gson.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

public class MillisecondsDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement jsonElement, Type type,
                                JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
            Date result = null;
            if (jsonElement != null) {
                Long milliseconds = jsonElement.getAsLong();
                result = new Date(milliseconds);
            }
            return result;
        }

        @Override
        public JsonElement serialize(Date date, Type type,
                                     JsonSerializationContext jsonSerializationContext) {
            JsonElement result = null;
            if (date != null) {
                Long milliseconds = date.getTime();
                result = new JsonPrimitive(milliseconds);
            }
            return result;
        }
    }