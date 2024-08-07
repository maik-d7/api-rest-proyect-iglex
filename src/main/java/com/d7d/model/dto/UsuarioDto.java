package com.d7d.model.dto;

import com.d7d.model.entity.Uso;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    private int idUsuario;

    private String nombreUsuario;

    private String correoUsuario;

    private String passUsuario;

    private Date fechaUsuario;
    //@JsonBackReference
    //@JsonManagedReference
    private List<UsoDto> usos;
}
