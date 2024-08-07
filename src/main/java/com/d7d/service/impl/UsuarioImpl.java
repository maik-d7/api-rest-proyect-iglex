package com.d7d.service.impl;

import com.d7d.model.dao.UsuarioDao;
import com.d7d.model.dto.UsoDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.model.entity.Uso;
import com.d7d.model.entity.Usuario;
import com.d7d.service.IUsuario;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;
    private ModelMapper modelMapper = new ModelMapper();


    @PostConstruct
    public void init() {
        modelMapper.addMappings(new PropertyMap<Usuario, UsuarioDto>() {
            @Override
            protected void configure() {
                map().setUsos(null);
            }
        });
    }


    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listAllx() {
        Iterable<Usuario> usuarios = usuarioDao.findAll();
        return StreamSupport.stream(usuarios.spliterator(), false)
                .map(usuario -> {
                    UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
                    List<UsoDto> usoDtos = usuario.getUsos().stream()
                            .map(uso -> modelMapper.map(uso, UsoDto.class))
                            .collect(Collectors.toList());
                    usuarioDto.setUsos(usoDtos);
                    return usuarioDto;
                })
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listAll() {
        Iterable<Usuario> usuarios = usuarioDao.findAll();
        List<UsuarioDto> usuarioDtosRes = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuarioDtosRes.add(modelMapper.map(usuario, UsuarioDto.class));
        }
        return usuarioDtosRes;

    }


    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioDao.findAll();
        return mapUsuariosToUsuarioDtos(usuarios);
    }

    private List<UsuarioDto> mapUsuariosToUsuarioDtos(Iterable<Usuario> usuarios) {
        return ((List<Usuario>) usuarios).stream()
                .map(usuario -> {
                    UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
                    List<UsoDto> usoDtos = usuario.getUsos().stream()
                            .map(uso -> {
                                UsoDto usoDto = modelMapper.map(uso, UsoDto.class);
                                usoDto.setUsuario(null); // Evita la referencia cíclica
                                return usoDto;
                            })
                            .collect(Collectors.toList());
                    usuarioDto.setUsos(usoDtos);
                    return usuarioDto;
                })
                .collect(Collectors.toList());
    }
}
