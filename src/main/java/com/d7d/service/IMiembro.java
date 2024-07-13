package com.d7d.service;

import com.d7d.model.dto.MiembroDto;
import com.d7d.model.entity.Miembro;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMiembro {

    public List<Miembro> listAll();
    public Miembro save(MiembroDto miembroDto);

    public Miembro findById(Integer id);
    public void delete(Miembro miembro);

    public List<Miembro> getAllMiembros();

}
