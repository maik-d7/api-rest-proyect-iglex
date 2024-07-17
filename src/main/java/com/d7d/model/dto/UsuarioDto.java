package com.d7d.model.dto;

import com.d7d.model.entity.Uso;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@Builder
public class UsuarioDto {
    private int idUsuario;

    private String nombreUsuario;

    private String correoUsuario;

    private String passUsuario;

    private Date fechaUsuario;

    private List<Uso> usos;
}
