package com.d7d.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    @OneToMany(mappedBy = "usuario", targetEntity = Uso.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Uso> usos;

}