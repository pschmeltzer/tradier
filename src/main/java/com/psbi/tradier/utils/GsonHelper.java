package com.psbi.tradier.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Peter.Schmeltzer on 5/20/2017.
 */
public class GsonHelper {

    private static final JsonSerializer<LocalDate> localDateSer = (src, typeOfSrc, context) ->
            src == null ? null : new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));

    private static final JsonDeserializer<LocalDate> localDateDeser = (json, typeOfT, context) ->
            json == null ? null : LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(json.getAsString()));

    private static final JsonSerializer<LocalDateTime> localDateTimeSer = (src, typeOfSrc, context) ->
            src == null ? null : new JsonPrimitive(src.toString());

    private static final JsonDeserializer<LocalDateTime> localDateTimeDeser = (json, typeOfT, context) ->
            json == null ? null : LocalDateTime.parse(json.getAsString());


    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, localDateSer)
            .registerTypeAdapter(LocalDate.class, localDateDeser)
            .registerTypeAdapter(LocalDateTime.class, localDateTimeSer)
            .registerTypeAdapter(LocalDateTime.class, localDateTimeDeser)
            .create();

    public static Gson getGson() {
        return gson;
    }


}
