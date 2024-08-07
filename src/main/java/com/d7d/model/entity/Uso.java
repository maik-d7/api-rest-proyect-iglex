package com.d7d.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "USO")
public class Uso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USA")
    private Integer idUsa;

    @Column(name = "ID_ENTIDAD_USA", nullable = false)
    private Integer idEntidadUsa;

    @Column(name = "NOMBRE_ENTIDAD_USA")
    private String nombreEntidadUsa;

    @Column(name = "ACCION_USA")
    private String accionUsa;

    @Column(name = "FECHA_USA")
    private Date fechaUsa;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
}