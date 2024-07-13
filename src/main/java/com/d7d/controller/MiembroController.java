package com.d7d.controller;

import com.d7d.model.dao.MiembroDao;
import com.d7d.model.dto.MiembroDto;
import com.d7d.model.entity.Miembro;
import com.d7d.model.payload.MessageResponse;
import com.d7d.service.IMiembro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MiembroController {

    @Autowired
    private IMiembro miembroService;

    @PostMapping("/miembro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody MiembroDto miembroDto) {
        ResponseEntity<?> responseEntity = null;
        Miembro miembroSave = null;
        try {
            miembroSave = miembroService.save(miembroDto);
            miembroDto = MiembroDto.builder()
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
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Se guardo.")
                            .datos(miembroDto)
                            .nombreTabla(miembroSave.getClass().getSimpleName())
                            .build()
                    , HttpStatus.CREATED
            );
        } catch (DataAccessException e) {
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("No guardado")
                            .datos(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }

    @PutMapping("/miembro")
    @ResponseStatus(HttpStatus.CREATED)
    public MiembroDto update(@RequestBody MiembroDto miembroDto) {
        Miembro miembroUpdate = miembroService.save(miembroDto);
        return MiembroDto.builder()
                .idMiembro(miembroUpdate.getIdMiembro())
                .idBautizo(miembroUpdate.getIdBautizo())
                .idObrero(miembroUpdate.getIdObrero())
                .nombreMiembro(miembroUpdate.getNombreMiembro())
                .apellidosMiembro(miembroUpdate.getApellidosMiembro())
                .fechaNacimientoMiembro(miembroUpdate.getFechaNacimientoMiembro())
                .ciMiembro(miembroUpdate.getCiMiembro())
                .telefonoMiembro(miembroUpdate.getTelefonoMiembro())
                .direccionMiembro(miembroUpdate.getDireccionMiembro())
                .build();
    }

    @DeleteMapping("/miembro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable int id) {
        ResponseEntity<?> responseEntity = null;
        Map<String, Object> response = new HashMap<>();//uso de Map

        try {
            Miembro miembroDelete = miembroService.findById(id);
            miembroService.delete(miembroDelete);

            response.put("mensaje", "Se elimino correctamente");
            response.put("cliente", miembroDelete);
            response.put("error", 0);

            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Se elimino correctamente")
                            .datos(miembroDelete)
                            .nombreTabla(miembroDelete.getClass().getSimpleName())
                            .build()
                    , HttpStatus.OK
            );
        } catch (DataAccessException exDta) {
            response.put("mensaje", exDta.getMessage());
            response.put("cliente", null);
            response.put("error", 1);

            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Registro no encontrado")
                            .datos(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }


    @GetMapping("/miembro/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable("id") Integer id) {
        ResponseEntity<?> responseEntity = null;
        Miembro miembroFiedById = new Miembro();
        MiembroDto miembrosDto = null;
        try {
            miembroFiedById = miembroService.findById(id);
            if (miembroFiedById == null) {
                responseEntity = new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("No se encontro.")
                                .datos(null)
                                .build()
                        , HttpStatus.INTERNAL_SERVER_ERROR
                );
            } else {
                miembrosDto = MiembroDto.builder()
                        .idMiembro(miembroFiedById.getIdMiembro())
                        .idBautizo(miembroFiedById.getIdBautizo())
                        .idObrero(miembroFiedById.getIdObrero())
                        .nombreMiembro(miembroFiedById.getNombreMiembro())
                        .apellidosMiembro(miembroFiedById.getApellidosMiembro())
                        .fechaNacimientoMiembro(miembroFiedById.getFechaNacimientoMiembro())
                        .ciMiembro(miembroFiedById.getCiMiembro())
                        .telefonoMiembro(miembroFiedById.getTelefonoMiembro())
                        .direccionMiembro(miembroFiedById.getDireccionMiembro())
                        .build();
                responseEntity = new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Se encontro.")
                                .datos(miembrosDto)
                                .nombreTabla(miembroFiedById.getClass().getSimpleName())
                                .build()
                        , HttpStatus.OK
                );
            }
        } catch (DataAccessException e) {
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("No se encontro.")
                            .datos(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }

    @GetMapping("/miembros")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAll() {
        ResponseEntity<?> responseEntity = null;
        List<MiembroDto> miembrosDto = new ArrayList<MiembroDto>();
        List<Miembro> miembros = miembroService.listAll();
        try {
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
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Se encontraron (" + miembros.size() + ") registros.")
                            .datos(miembrosDto)
//                            .nombreTabla(miembros.get(0).getClass().getSimpleName())
                            .build()
                    , HttpStatus.OK
            );

        }catch (DataAccessException e) {
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("No se encontro.")
                            .datos(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }

    @GetMapping("/miembros2")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<Miembro> getAll() {
        return miembroService.getAllMiembros();
    }

}
