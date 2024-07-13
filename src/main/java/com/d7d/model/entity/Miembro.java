package com.d7d.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "miembro")
public class Miembro implements java.io.Serializable {

    @Id
    @Column(name = "id_Miembro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMiembro;

    @Column(name = "id_Bautizo")
    private Integer idBautizo;

    @Column(name = "id_Obrero")
    private Integer idObrero;

    @Column(name = "nombre_Miembro")
    private String nombreMiembro;

    @Column(name = "apellidos_Miembro")
    private String apellidosMiembro;

    @Column(name = "fecha_Nacimiento_Miembro")
    private Date fechaNacimientoMiembro;

    @Column(name = "ci_Miembro")
    private String ciMiembro;

    @Column(name = "telefono_Miembro")
    private Integer telefonoMiembro;

    @Column(name = "direccion_Miembro")
    private String direccionMiembro;
}
