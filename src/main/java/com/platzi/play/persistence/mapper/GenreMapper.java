package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.Genre;
import org.mapstruct.Named;

import java.util.Map;
import java.util.stream.Collectors;


public class GenreMapper {

    private static final Map<Genre, String> GENRE_MAP = Map.of(
            Genre.ACTION, "ACCION",
            Genre.COMEDY, "COMEDIA",
            Genre.DRAMA, "DRAMA",
            Genre.ANIMATED, "ANIMADA",
            Genre.HORROR, "TERROR",
            Genre.SCI_FI, "CIENCIA_FICCION"
    );

    // Reverse map: string → enum
    private static final Map<String, Genre> STRING_TO_GENRE_MAP =
            GENRE_MAP.entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            e -> e.getValue().toUpperCase(), // key: Spanish string uppercased
                            Map.Entry::getKey                // value: enum
                    ));

    @Named("stringToGenre")
    public static Genre stringToGenre(String genero) {
        return genero == null ? null : STRING_TO_GENRE_MAP.get(genero.toUpperCase());
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        return genre == null ? null : GENRE_MAP.get(genre);
    }
}
