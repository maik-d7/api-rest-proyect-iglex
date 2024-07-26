package com.d7d.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MIEMBRO")
public class Miembro implements java.io.Serializable {

    @Id
    @Column(name = "ID_MIEMBRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMiembro;

    @Column(name = "ID_BAUTIZO")
    private Integer idBautizo;

    @Column(name = "ID_OBRERO")
    private Integer idObrero;

    @Column(name = "NOMBRE_MIEMBRO")
    private String nombreMiembro;

    @Column(name = "APELLIDOS_MIEMBRO")
    private String apellidosMiembro;

    @Column(name = "FECHA_NACIMIENTO_MIEMBRO")
    private Date fechaNacimientoMiembro;

    @Column(name = "CI_MIEMBRO")
    private String ciMiembro;

    @Column(name = "TELEFONO_MIEMBRO")
    private Integer telefonoMiembro;

    @Column(name = "DIRECCION_MIEMBRO")
    private String direccionMiembro;
}
