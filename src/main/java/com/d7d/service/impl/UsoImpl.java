package com.d7d.service.impl;

import com.d7d.model.dao.UsoDao;
import com.d7d.model.dto.UsoDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.model.entity.Uso;
import com.d7d.model.entity.Usuario;
import com.d7d.service.IUso;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsoImpl implements IUso {

    @Autowired
    private UsoDao usoDao;
    private ModelMapper modelMapper = new ModelMapper();

    public UsoImpl(UsoDao usoDao) {
        this.usoDao = usoDao;

        // Mapeo de Usuario a UsuarioDto
        modelMapper.typeMap(Usuario.class, UsuarioDto.class).addMappings(mapper -> {
            mapper.skip(UsuarioDto::setUsos); // Omitir la lista de usos para evitar ciclos
        });

        // Mapeo de Uso a UsoDto
        modelMapper.typeMap(Uso.class, UsoDto.class).addMappings(mapper -> {
            mapper.skip(UsoDto::setUsuario); // Omitir el usuario para evitar ciclos
        });
    }

    @Override
    public List<UsoDto> listAllx() {
        List<UsoDto> usoDto = new ArrayList<>();
        Iterable<Uso> usos = usoDao.findAll();

        for (Uso uso : usos) {
            UsoDto mappedUso = modelMapper.map(uso, UsoDto.class);
            // Mapear manualmente el campo usuario si es necesario
            if (uso.getUsuario() != null) {
                UsuarioDto usuarioDto = new UsuarioDto();
                usuarioDto.setIdUsuario(uso.getUsuario().getIdUsuario());
                usuarioDto.setNombreUsuario(uso.getUsuario().getNombreUsuario());
                mappedUso.setUsuario(usuarioDto);
            }
            usoDto.add(mappedUso);
        }
        return usoDto;
    }


    @Override
    public List<UsoDto> listAll(){
        Iterable<Uso> usos = usoDao.findAll();
        List<UsoDto> usoDto = new ArrayList<>();

        for (Uso uso : usos){
            usoDto.add(modelMapper.map(uso, UsoDto.class));
        }
        return usoDto;
    }
}

