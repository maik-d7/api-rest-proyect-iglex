package com.d7d.model.dto;

import com.d7d.model.entity.Usuario;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
public class UsoDto {
    private int idUsa;

    private Usuario usuario;

    private int idEntidadUsa;

    private String nombreEntidadUsa;

    private String accionUsa;

    private Date fechaUsa;

}
