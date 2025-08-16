package com.platzi.play.domain.dto;

import com.platzi.play.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MovieDto(
        Long id,

        @NotBlank(message = "El título es obligatorio.")
        String title,

        @NotNull(message = "La duración en obligatoria.")
        Integer duration,

        @NotNull(message = "El género es obligatorio.")
        Genre genre,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual.")
        LocalDate releaseAt,

        @Min(value = 0, message = "El rating no puede ser menor que 0.")
        @Max(value = 5, message = "El rating no puede ser mayor que 5.")
        Double rating,

        @NotNull(message = "El estado es obligatorio.")
        Boolean status
) {
}
