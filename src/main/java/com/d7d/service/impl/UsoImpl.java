package com.d7d.service.impl;

import com.d7d.model.dao.UsoDao;
import com.d7d.model.dto.UsoDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.model.entity.Uso;
import com.d7d.model.entity.Usuario;
import com.d7d.service.IUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsoImpl implements IUso {

    @Autowired
    private UsoDao usoDao;

    @Override
    public List<UsoDto> listAll() {
        List<UsoDto> usoDto = new ArrayList<>();
        Iterable<Uso> usos = usoDao.findAll();

        for (Uso uso : usos) {
            usoDto.add(UsoDto.builder()
                    .idUsa(uso.getIdUsa())
                    .usuario(uso.getUsuario())
                    .idEntidadUsa(uso.getIdEntidadUsa())
                    .nombreEntidadUsa(uso.getNombreEntidadUsa())
                    .accionUsa(uso.getAccionUsa())
                    .fechaUsa(uso.getFechaUsa())
                    .build());
        }
        return usoDto;
    }
}

