package com.d7d.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String nombreUsuario;

    @Column(name = "CORREO_USUARIO")
    private String correoUsuario;

    @Column(name = "PASS_USUARIO", nullable = false)
    private String passUsuario;

    @Column(name = "FECHA_USUARIO")
    private Date fechaUsuario;

    @OneToMany(targetEntity = Uso.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private List<Uso> usos;
}