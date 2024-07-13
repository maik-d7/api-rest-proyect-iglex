package com.d7d.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
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
