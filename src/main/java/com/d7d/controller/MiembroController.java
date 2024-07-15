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
        MiembroDto miembroSave = null;
        try {
            miembroSave = miembroService.save(miembroDto);
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Se guardo.")
                            .datos(miembroSave)
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
        MiembroDto miembroUpdate = miembroService.save(miembroDto);
        return miembroUpdate;
    }

    @DeleteMapping("/miembro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable int id) {
        ResponseEntity<?> responseEntity = null;
        Map<String, Object> response = new HashMap<>();//uso de Map

        try {
            MiembroDto miembroDelete = miembroService.findById(id);
            if(miembroDelete != null){
                miembroService.delete(miembroDelete);

                response.put("mensaje", "Se elimino correctamente");
                response.put("cliente", miembroDelete);
                response.put("error", 0);

                responseEntity = new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Se elimino correctamente")
                                .datos(miembroDelete)
                                .nombreTabla("Miembro")
                                .build()
                        , HttpStatus.OK
                );
            }
            else{
                responseEntity = new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("No exist el registro :" +id)
                                .datos("null")
                                .nombreTabla("Miembro")
                                .build()
                        , HttpStatus.OK
                );
            }
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
        MiembroDto miembroFiedById = null;
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
                responseEntity = new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Se encontro.")
                                .datos(miembroFiedById)
                                .nombreTabla("Miembro")
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
        List<MiembroDto> miembrosDto = miembroService.listAll();
        try {
            responseEntity = new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Se encontraron (" + miembrosDto.size() + ") registros.")
                            .datos(miembrosDto)
                            .nombreTabla("Miembro")
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
    public List<MiembroDto> getAll() {
        return miembroService.getAllMiembros();
    }

}
