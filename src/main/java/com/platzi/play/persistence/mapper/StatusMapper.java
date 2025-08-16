package com.platzi.play.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {
    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        return "D".equalsIgnoreCase(estado);
    }

    @Named("booleanToString")
    public static String booleanToString(Boolean status) {
        return Boolean.TRUE.equals(status) ? "D" : "N";
    }
}
