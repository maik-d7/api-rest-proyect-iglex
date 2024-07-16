package com.d7d.service.impl;

import com.d7d.model.dao.MiembroDao;
import com.d7d.model.dto.MiembroDto;
import com.d7d.model.entity.Miembro;
import com.d7d.service.IMiembro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiembroImpl implements IMiembro {

    @Autowired
    private MiembroDao miembroDao;

    @Transactional(readOnly = true)
    @Override
    public List<MiembroDto> listAll() {
        List<MiembroDto> miembrosDto = null;
        List<Miembro> miembros = miembroDao.getAllMiembros();
        for (Miembro miembro1 : miembros) {
            miembrosDto.add(MiembroDto.builder()
                    .idMiembro(miembro1.getIdMiembro())
                    .idBautizo(miembro1.getIdBautizo())
                    .idObrero(miembro1.getIdObrero())
                    .nombreMiembro(miembro1.getNombreMiembro())
                    .apellidosMiembro(miembro1.getApellidosMiembro())
                    .fechaNacimientoMiembro(miembro1.getFechaNacimientoMiembro())
                    .ciMiembro(miembro1.getCiMiembro())
                    .telefonoMiembro(miembro1.getTelefonoMiembro())
                    .direccionMiembro(miembro1.getDireccionMiembro())
                    .build());
        }

        return miembrosDto;
    }
    @Transactional
    @Override
    public MiembroDto save(MiembroDto miembroDto) {
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
        Miembro miembroSave = miembroDao.save(miembro);
        MiembroDto miembrosDtoSave = MiembroDto.builder()
                .idMiembro(miembroSave.getIdMiembro())
                .idBautizo(miembroSave.getIdBautizo())
                .idObrero(miembroSave.getIdObrero())
                .nombreMiembro(miembroSave.getNombreMiembro())
                .apellidosMiembro(miembroSave.getApellidosMiembro())
                .fechaNacimientoMiembro(miembroSave.getFechaNacimientoMiembro())
                .ciMiembro(miembroSave.getCiMiembro())
                .telefonoMiembro(miembroSave.getTelefonoMiembro())
                .direccionMiembro(miembroSave.getDireccionMiembro())
                .build();
        return miembrosDtoSave;
    }

    @Transactional(readOnly = true)
    @Override
    public MiembroDto findById(Integer id) {
        Miembro miembroFindById = miembroDao.findById(id).orElse(null);
        MiembroDto miembrosDtoSave = null;
        if(miembroFindById != null){
            miembrosDtoSave = MiembroDto.builder()
                    .idMiembro(miembroFindById.getIdMiembro())
                    .idBautizo(miembroFindById.getIdBautizo())
                    .idObrero(miembroFindById.getIdObrero())
                    .nombreMiembro(miembroFindById.getNombreMiembro())
                    .apellidosMiembro(miembroFindById.getApellidosMiembro())
                    .fechaNacimientoMiembro(miembroFindById.getFechaNacimientoMiembro())
                    .ciMiembro(miembroFindById.getCiMiembro())
                    .telefonoMiembro(miembroFindById.getTelefonoMiembro())
                    .direccionMiembro(miembroFindById.getDireccionMiembro())
                    .build();
        }
        return miembrosDtoSave;
    }
    @Transactional
    @Override
    public void delete(MiembroDto miembroDto) {

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

        miembroDao.delete(miembro);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MiembroDto> getAllMiembros() {
        List<MiembroDto> miembrosDto = new ArrayList<>();
        List<Miembro> miembros = miembroDao.getAllMiembros();
        for (Miembro miembro1 : miembros) {
            miembrosDto.add(MiembroDto.builder()
                    .idMiembro(miembro1.getIdMiembro())
                    .idBautizo(miembro1.getIdBautizo())
                    .idObrero(miembro1.getIdObrero())
                    .nombreMiembro(miembro1.getNombreMiembro())
                    .apellidosMiembro(miembro1.getApellidosMiembro())
                    .fechaNacimientoMiembro(miembro1.getFechaNacimientoMiembro())
                    .ciMiembro(miembro1.getCiMiembro())
                    .telefonoMiembro(miembro1.getTelefonoMiembro())
                    .direccionMiembro(miembro1.getDireccionMiembro())
                    .build());
        }

        return miembrosDto;
    }

}
