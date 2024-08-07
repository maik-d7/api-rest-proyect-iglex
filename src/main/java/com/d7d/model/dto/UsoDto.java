package com.d7d.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsoDto {

    private Integer idUsa;

    private Integer idEntidadUsa;

    //@JsonManagedReference
    //@JsonBackReference
    private UsuarioDto usuario;

    private String nombreEntidadUsa;

    private String accionUsa;

    private Date fechaUsa;

}
