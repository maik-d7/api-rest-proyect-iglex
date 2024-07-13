package com.d7d.service.impl;

import com.d7d.model.dao.MiembroDao;
import com.d7d.model.dto.MiembroDto;
import com.d7d.model.entity.Miembro;
import com.d7d.service.IMiembro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiembroImpl implements IMiembro {

    @Autowired
    private MiembroDao miembroDao;

    @Transactional(readOnly = true)
    @Override
    public List<Miembro> listAll() {
        return (List<Miembro>) miembroDao.findAll();
    }
    @Transactional
    @Override
    public Miembro save(MiembroDto miembroDto) {
        Miembro miembro = Miembro.builder()
                .idMiembro(miembroDto.getIdMiembro())
                .idBautizo(miembroDto.getIdBautizo())
                .idObrero(miembroDto.getIdObrero())
                .nombreMiembro(miembroDto.getNombreMiembro())
                .apellidosMiembro(miembroDto.getApellidosMiembro())
                .fechaNacimientoMiembro(miembroDto.getFechaNacimientoMiembro())
                .ciMiembro(miembroDto.getCiMiembro())
                .telefonoMiembro(miembroDto.getTelefonoMiembro())
                .direccionMiembro(miembroDto.getDireccionMiembro())
                .build();
        return miembroDao.save(miembro);
    }

    @Transactional(readOnly = true)
    @Override
    public Miembro findById(Integer id) {
        return miembroDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Miembro miembro) {
        miembroDao.delete(miembro);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Miembro> getAllMiembros() {
        return miembroDao.getAllMiembros();
    }

}
