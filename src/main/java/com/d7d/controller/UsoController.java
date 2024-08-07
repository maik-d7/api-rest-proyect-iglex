package com.d7d.controller;


import com.d7d.model.dto.UsoDto;
import com.d7d.service.IUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uso/api/v1")
public class UsoController {
    @Autowired
    private IUso usoServivio;

    @GetMapping("/showAll")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<UsoDto> getAll() {
        return usoServivio.listAll();
    }

}
