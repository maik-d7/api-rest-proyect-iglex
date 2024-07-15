package com.d7d.model.dao;

import com.d7d.model.entity.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;// ya esta pasado de uso
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;// para gran candidad de datos
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiembroDao extends CrudRepository<Miembro, Integer> {

    @Query(value = " SELECT * FROM MIEMBRO ORDER BY id_miembro ASC; ", nativeQuery = true)
    List<Miembro> getAllMiembros();

}
