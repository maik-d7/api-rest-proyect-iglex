package com.d7d.controller;


import com.d7d.model.dto.MiembroDto;
import com.d7d.model.dto.UsuarioDto;
import com.d7d.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;


    @GetMapping("/showAll")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<UsuarioDto> getAll() {
        return usuarioService.listAll();
    }
}
