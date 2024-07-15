package com.d7d.service;

import com.d7d.model.dto.MiembroDto;
import com.d7d.model.entity.Miembro;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMiembro {

    public List<MiembroDto> listAll();
    public MiembroDto save(MiembroDto miembroDto);

    public MiembroDto findById(Integer id);
    public void delete(MiembroDto miembro);

    public List<MiembroDto> getAllMiembros();

}
