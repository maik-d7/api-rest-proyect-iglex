package com.d7d.model.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@ArraySchema
@NoArgsConstructor
@AllArgsConstructor
public class MiembroDto implements java.io.Serializable {

    private int idMiembro;

    private Integer idBautizo;

    private Integer idObrero;

    private String nombreMiembro;

    private String apellidosMiembro;

    private Date fechaNacimientoMiembro;

    private String ciMiembro;

    private Integer telefonoMiembro;

    private String direccionMiembro;
}
