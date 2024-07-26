package com.d7d.service.impl;

import com.d7d.model.dao.UsuarioDao;
import com.d7d.model.dto.MiembroDto;
import com.d7d.model.dto.UsoDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.model.entity.Miembro;
import com.d7d.model.entity.Uso;
import com.d7d.model.entity.Usuario;
import com.d7d.service.IUsuario;
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

//    @Override
//    @Transactional(readOnly = true)
//    public List<UsuarioDto> listAll() {
//        List<UsuarioDto> usuarioDto = new ArrayList<>();
//        Iterable<Usuario> usuarios = usuarioDao.findAll();
//        List<UsoDto> usoDtos = new ArrayList<>();
//
//        for (Usuario usuario : usuarios) {
//            usuarioDto.add(UsuarioDto.builder()
//                    .idUsuario(usuario.getIdUsuario())
//                    .nombreUsuario(usuario.getNombreUsuario())
//                    .correoUsuario(usuario.getCorreoUsuario())
//                    .passUsuario(usuario.getPassUsuario())
//                    .fechaUsuario(usuario.getFechaUsuario())
//                    .usos( /* quiero usar aqui la esprecion lambda*/)
//                    .build());
//        }
//        return usuarioDto;
//    }


    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listAll() {
        Iterable<Usuario> usuarios = usuarioDao.findAll();

        return StreamSupport.stream(usuarios.spliterator(), false)
                .map(usuario -> UsuarioDto.builder()
                        .idUsuario(usuario.getIdUsuario())
                        .nombreUsuario(usuario.getNombreUsuario())
                        .correoUsuario(usuario.getCorreoUsuario())
                        .passUsuario(usuario.getPassUsuario())
                        .fechaUsuario(usuario.getFechaUsuario())
                        .usos(usuario.getUsos().stream()
                                .map(uso -> UsoDto.builder()
                                        .idUsa(uso.getIdUsa())
                                        .idEntidadUsa(uso.getIdEntidadUsa())
                                        .idusuario(uso.getUsuario().getIdUsuario())
                                        .fechaUsa(uso.getFechaUsa())
                                        .accionUsa(uso.getAccionUsa())
                                        .nombreEntidadUsa(uso.getNombreEntidadUsa())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }


    private List<UsoDto> UsoAUsoDto(List<Uso> usos) {
        List<UsoDto> rUsoDto = new ArrayList<>();

        for (Uso uso : usos) {
            rUsoDto.add(UsoDto.builder()
                    .idUsa(uso.getIdUsa())
                    .idEntidadUsa(uso.getIdEntidadUsa())
                    .idusuario(uso.getUsuario().getIdUsuario())
                    .fechaUsa(uso.getFechaUsa())
                    .accionUsa(uso.getAccionUsa())
                    .nombreEntidadUsa(uso.getNombreEntidadUsa())
                    .build()
            );
        }
        return rUsoDto;
    }
}
