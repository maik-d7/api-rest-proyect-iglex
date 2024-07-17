package com.d7d.service.impl;

import com.d7d.model.dao.UsuarioDao;
import com.d7d.model.dto.MiembroDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.model.entity.Miembro;
import com.d7d.model.entity.Usuario;
import com.d7d.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listAll() {
        List<UsuarioDto> usuarioDto = new ArrayList<>();
        Iterable<Usuario> usuarios = usuarioDao.findAll();

        for (Usuario usuario : usuarios) {
            usuarioDto.add(UsuarioDto.builder()
                    .idUsuario(usuario.getIdUsuario())
                    .nombreUsuario(usuario.getNombreUsuario())
                    .correoUsuario(usuario.getCorreoUsuario())
                    .passUsuario(usuario.getPassUsuario())
                    .fechaUsuario(usuario.getFechaUsuario())
                    .usos(new ArrayList<>() )
                    .build());
        }
        return usuarioDto;
    }
}
